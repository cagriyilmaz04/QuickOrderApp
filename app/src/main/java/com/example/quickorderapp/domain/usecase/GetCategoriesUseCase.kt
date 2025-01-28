package com.example.quickorderapp.domain.usecase

import com.example.quickorderapp.domain.repository.CategoryRepository


class GetCategoriesUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke() = repository.getCategories()
}