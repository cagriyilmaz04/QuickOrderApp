package com.example.quickorderapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quickorderapp.presentation.viewmodel.CategoriesViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.quickorderapp.presentation.Screen
import com.example.quickorderapp.presentation.cards.CategoryGrid
import com.example.quickorderapp.util.encodeUrl

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel()
) {
    val uiState by viewModel.categoriesUiState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is CategoryUiState.Loading -> {
                CircularProgressIndicator()
            }
            is CategoryUiState.Success -> {
                CategoryGrid(
                    categories = (uiState as CategoryUiState.Success).categories,
                    onItemClick = { category ->
                        navController.navigate(
                            Screen.Meal.createRoute(
                                categoryId = category.id,
                                categoryName = encodeUrl(category.name),
                                categoryThumbnail = encodeUrl(category.thumbnail)
                            )
                        )
                    }
                )
            }
            is CategoryUiState.Error -> {
                Text(text = (uiState as CategoryUiState.Error).message)
            }
        }
    }
}