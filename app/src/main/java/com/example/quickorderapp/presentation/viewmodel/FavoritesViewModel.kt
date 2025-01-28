package com.example.quickorderapp.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickorderapp.domain.model.Meal
import com.example.quickorderapp.domain.usecase.FavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val useCase: FavoritesUseCase
) : ViewModel() {
    val favorites: StateFlow<List<Meal>> = useCase.getAllFavorites()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addFavorite(meal: Meal) {
        viewModelScope.launch {
            useCase.addFavorite(meal)
        }
    }

    fun removeFavorite(meal: Meal) {
        viewModelScope.launch {
            useCase.removeFavorite(meal)
        }
    }
}
