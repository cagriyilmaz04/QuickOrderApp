package com.example.quickorderapp.domain.repository

import com.example.quickorderapp.domain.model.Meal

interface MealRepository {
    suspend fun getMealsByCategory(category: String): List<Meal>
}
