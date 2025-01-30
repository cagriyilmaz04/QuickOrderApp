package com.example.quickorderapp.data.repository

import com.example.quickorderapp.data.mappers.toDomainList
import com.example.quickorderapp.data.remote.CloudApiService
import com.example.quickorderapp.data.remote.TheMealDBApiService
import com.example.quickorderapp.domain.model.Category
import com.example.quickorderapp.domain.model.Meal
import com.example.quickorderapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val cloudApiService: CloudApiService, // Cloud API
    private val mealDBApiService: TheMealDBApiService // TheMealDB API
) : MealRepository {

    // Kategorileri TheMealDB API'den alıyoruz
    override suspend fun getCategories(): Flow<List<Category>> = flow {
        try {
            val response = mealDBApiService.getCategories()
            val categories = response.categories.map {
                Category(
                    id = it.id,
                    name = it.name,
                    description = it.description,
                    thumbnail = it.thumbnail
                )
            }
            emit(categories)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)

    // Yemekleri Cloud API'den alıyoruz
    override suspend fun getMealsByCategory(category: String): Flow<List<Meal>> = flow {
        try {
            val response = cloudApiService.getMealsByCategory(category)
            val meals = response.meals.toDomainList()
            emit(meals)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}
