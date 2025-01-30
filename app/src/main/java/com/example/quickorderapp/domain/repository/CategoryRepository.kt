package com.example.quickorderapp.domain.repository

import com.example.quickorderapp.domain.model.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}
