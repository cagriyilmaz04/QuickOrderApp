package com.example.quickorderapp.domain.usecase

import com.example.quickorderapp.domain.repository.MealRepository

class GetMealsByCategoryUseCase(
    private val repository: MealRepository
) {
    suspend operator fun invoke(category: String) = repository.getMealsByCategory(category)
}
