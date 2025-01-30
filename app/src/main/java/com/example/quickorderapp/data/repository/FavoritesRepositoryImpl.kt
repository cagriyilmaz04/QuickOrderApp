package com.example.quickorderapp.data.repository

import com.example.quickorderapp.data.local.FavoritesDao
import com.example.quickorderapp.data.local.MealEntity
import com.example.quickorderapp.domain.model.Meal
import com.example.quickorderapp.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoritesRepositoryImpl(
    private val dao: FavoritesDao
) : FavoritesRepository {
    override fun getAllFavorites(): Flow<List<Meal>> {
        return dao.getAllFavorites().map { entities ->
            entities.map { entity ->
                Meal(
                    id = entity.id,
                    name = entity.name,
                    thumbnail = entity.thumbnail,
                    price = entity.price,
                    description = entity.description
                )
            }
        }
    }

    override suspend fun addFavorite(meal: Meal) {
        dao.addFavorite(MealEntity(meal.id, meal.name, meal.thumbnail,meal.price,meal.description))
    }

    override suspend fun removeFavorite(meal: Meal) {
        dao.removeFavorite(MealEntity(meal.id, meal.name, meal.thumbnail,meal.price,meal.description))
    }
}
