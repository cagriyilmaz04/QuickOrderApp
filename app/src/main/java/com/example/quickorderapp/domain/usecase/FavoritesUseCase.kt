package com.example.quickorderapp.domain.usecase

import com.example.quickorderapp.domain.model.Meal
import com.example.quickorderapp.domain.repository.FavoritesRepository

class FavoritesUseCase(
    private val repository: FavoritesRepository
) {
    fun getAllFavorites() = repository.getAllFavorites()
    suspend fun addFavorite(meal: Meal) = repository.addFavorite(meal)
    suspend fun removeFavorite(meal: Meal) = repository.removeFavorite(meal)
}
