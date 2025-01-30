package com.example.quickorderapp.domain.repository

import com.example.quickorderapp.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<List<Category>>
}
