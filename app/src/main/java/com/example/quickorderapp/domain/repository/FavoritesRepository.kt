package com.example.quickorderapp.domain.repository

import com.example.quickorderapp.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getAllFavorites(): Flow<List<Meal>>
    suspend fun addFavorite(meal: Meal)
    suspend fun removeFavorite(meal: Meal)
}
