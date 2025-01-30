package com.example.quickorderapp.di

import android.content.Context
import androidx.room.Room
import com.airbnb.lottie.compose.BuildConfig
import com.example.quickorderapp.data.local.FavoritesDao
import com.example.quickorderapp.data.local.FavoritesDatabase
import com.example.quickorderapp.data.remote.ApiService
import com.example.quickorderapp.data.repository.CategoryRepositoryImpl
import com.example.quickorderapp.data.repository.FavoritesRepositoryImpl
import com.example.quickorderapp.data.repository.MealRepositoryImpl
import com.example.quickorderapp.domain.repository.CategoryRepository
import com.example.quickorderapp.domain.repository.FavoritesRepository
import com.example.quickorderapp.domain.repository.MealRepository
import com.example.quickorderapp.domain.usecase.FavoritesUseCase
import com.example.quickorderapp.domain.usecase.GetCategoriesUseCase
import com.example.quickorderapp.domain.usecase.GetMealsByCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(apiService: ApiService): CategoryRepository {
        return CategoryRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(repository: CategoryRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMealRepository(apiService: ApiService): MealRepository {
        return MealRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetMealsByCategoryUseCase(repository: MealRepository): GetMealsByCategoryUseCase {
        return GetMealsByCategoryUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideFavoritesDatabase(@ApplicationContext context: Context): FavoritesDatabase {
        return Room.databaseBuilder(
            context,
            FavoritesDatabase::class.java,
            "favorites_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoritesDao(database: FavoritesDatabase): FavoritesDao {
        return database.favoritesDao()
    }

    @Provides
    @Singleton
    fun provideFavoritesRepository(dao: FavoritesDao): FavoritesRepository {
        return FavoritesRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideFavoritesUseCase(repository: FavoritesRepository): FavoritesUseCase {
        return FavoritesUseCase(repository)
    }
}
