package com.example.quickorderapp.presentation.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quickorderapp.presentation.cards.MealGrid
import com.example.quickorderapp.presentation.viewmodel.MealsViewModel

@Composable
fun MealScreen(
    viewModel: MealsViewModel = hiltViewModel(),
    category: String
) {
    val uiState by viewModel.mealsUiState.collectAsState()

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
                onItemClick = { meal ->
                    println("Meal clicked: ${meal.name}")
                }
            )
        }
        is MealsUiState.Error -> {
            Text(text = (uiState as MealsUiState.Error).message)
        }
    }
}
