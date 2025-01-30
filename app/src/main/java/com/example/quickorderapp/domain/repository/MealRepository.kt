package com.example.quickorderapp.domain.repository

import com.example.quickorderapp.domain.model.Category
import com.example.quickorderapp.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getMealsByCategory(category: String): Flow<List<Meal>>
    suspend fun getCategories(): Flow<List<Category>>
}
