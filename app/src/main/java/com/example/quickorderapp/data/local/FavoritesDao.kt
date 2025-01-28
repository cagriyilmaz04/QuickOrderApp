package com.example.quickorderapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<MealEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(meal: MealEntity)

    @Delete
    suspend fun removeFavorite(meal: MealEntity)
}