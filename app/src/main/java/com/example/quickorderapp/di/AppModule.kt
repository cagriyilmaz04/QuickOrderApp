package com.example.quickorderapp.di

import com.example.quickorderapp.data.remote.ApiService
import com.example.quickorderapp.data.repository.CategoryRepositoryImpl
import com.example.quickorderapp.data.repository.MealRepositoryImpl
import com.example.quickorderapp.domain.repository.CategoryRepository
import com.example.quickorderapp.domain.repository.MealRepository
import com.example.quickorderapp.domain.usecase.GetCategoriesUseCase
import com.example.quickorderapp.domain.usecase.GetMealsByCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
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
}