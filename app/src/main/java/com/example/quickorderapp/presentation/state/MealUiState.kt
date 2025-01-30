package com.example.quickorderapp.presentation.state

import com.example.quickorderapp.domain.model.Meal

sealed class MealsUiState {
    object Loading : MealsUiState()
    data class Success(val meals: List<Meal>) : MealsUiState()
    data class Error(val message: String) : MealsUiState()
}
