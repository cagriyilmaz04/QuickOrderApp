package com.example.quickorderapp.presentation.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quickorderapp.presentation.cards.MealGrid
import com.example.quickorderapp.presentation.state.MealsUiState
import com.example.quickorderapp.presentation.viewmodel.MealsViewModel

@Composable
fun MealScreen(
    viewModel: MealsViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(), // Favoriler için ViewModel
    category: String
) {
    val uiState by viewModel.mealsUiState.collectAsState()
    val favorites by favoritesViewModel.favorites.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMeals(category)
    }

    when (uiState) {
        is MealsUiState.Loading -> {
            CircularProgressIndicator()
        }
        is MealsUiState.Success -> {
            val meals = (uiState as MealsUiState.Success).meals
            MealGrid(
                meals = meals,
                favorites = favorites,
                onItemClick = { meal ->

                    println("Meal clicked: ${meal.name}")
                },
                onFavoriteClick = { meal ->

                    if (favorites.contains(meal)) {
                        favoritesViewModel.removeFavorite(meal)
                    } else {
                        favoritesViewModel.addFavorite(meal)
                    }
                }
            )
        }
        is MealsUiState.Error -> {
            Text(text = (uiState as MealsUiState.Error).message)
        }
    }
}
