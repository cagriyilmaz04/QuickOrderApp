package com.example.quickorderapp.data.repository

import com.example.quickorderapp.data.remote.TheMealDBApiService
import com.example.quickorderapp.domain.model.Category
import com.example.quickorderapp.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CategoryRepositoryImpl(
    private val apiService: TheMealDBApiService // Burayı ApiService yerine TheMealDBApiService yap
) : CategoryRepository {
    override suspend fun getCategories(): Flow<List<Category>> = flow {
        try {
            val response = apiService.getCategories() // TheMealDBApiService ile çağır
            val categories = response.categories.map { Category(it.id, it.name, it.thumbnail,it.description) }
            emit(categories)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}
