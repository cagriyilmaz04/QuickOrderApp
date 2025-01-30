package com.example.quickorderapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickorderapp.domain.usecase.GetMealsByCategoryUseCase
import com.example.quickorderapp.presentation.state.MealsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsByCategoryUseCase: GetMealsByCategoryUseCase
) : ViewModel() {

    private val _mealsUiState = MutableStateFlow<MealsUiState>(MealsUiState.Loading)
    val mealsUiState: StateFlow<MealsUiState> = _mealsUiState

    fun fetchMeals(category: String) {
        viewModelScope.launch {
            try {
                val meals = getMealsByCategoryUseCase(category)
                _mealsUiState.value = MealsUiState.Success(meals)
            } catch (e: Exception) {
                _mealsUiState.value = MealsUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
