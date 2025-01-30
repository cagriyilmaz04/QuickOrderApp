package com.example.quickorderapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quickorderapp.presentation.navigation.Screen
import com.example.quickorderapp.presentation.animations.AnimatedCategoryGrid
import com.example.quickorderapp.presentation.animations.AnimatedErrorMessage
import com.example.quickorderapp.presentation.animations.AnimatedLoading
import com.example.quickorderapp.presentation.state.CategoryUiState
import com.example.quickorderapp.presentation.viewmodel.CategoriesViewModel
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
                AnimatedLoading()
            }
            is CategoryUiState.Success -> {
                AnimatedCategoryGrid(
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
                AnimatedErrorMessage((uiState as CategoryUiState.Error).message)
            }
        }
    }
}
