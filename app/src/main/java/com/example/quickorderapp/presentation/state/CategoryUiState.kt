package com.example.quickorderapp.presentation.state

import com.example.quickorderapp.domain.model.Category

sealed class CategoryUiState {
    object Loading : CategoryUiState()
    data class Success(val categories: List<Category>) : CategoryUiState()
    data class Error(val message: String) : CategoryUiState()
}
