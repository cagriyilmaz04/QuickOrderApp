package com.example.quickorderapp.data.repository

import com.example.quickorderapp.data.remote.ApiService
import com.example.quickorderapp.domain.model.Meal
import com.example.quickorderapp.domain.repository.MealRepository

class MealRepositoryImpl(
    private val apiService: ApiService
) : MealRepository {
    override suspend fun getMealsByCategory(category: String): List<Meal> {
        return apiService.getMealsByCategory(category).meals.map {
            Meal(
                id = it.id,
                name = it.name,
                thumbnail = it.thumbnail
            )
        }
    }
}
