package com.example.quickorderapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class MealEntity(
    @PrimaryKey val id: String,
    val name: String,
    val thumbnail: String
)
