package com.example.quickorderapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickorderapp.domain.usecase.GetCategoriesUseCase
import com.example.quickorderapp.presentation.state.CategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categoriesUiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Loading)
    val categoriesUiState: StateFlow<CategoryUiState> = _categoriesUiState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categories = getCategoriesUseCase()
                _categoriesUiState.value = CategoryUiState.Success(categories)
            } catch (e: Exception) {
                _categoriesUiState.value = CategoryUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
