package com.example.quickorderapp.data.repository

import com.example.quickorderapp.data.remote.ApiService
import com.example.quickorderapp.domain.model.Category
import com.example.quickorderapp.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val apiService: ApiService
) : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return apiService.getCategories().categories.map {
            Category(
                id = it.id,
                name = it.name,
                thumbnail = it.thumbnail,
                description = it.description
            )
        }
    }
}