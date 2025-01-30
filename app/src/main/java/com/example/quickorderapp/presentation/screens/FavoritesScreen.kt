package com.example.quickorderapp.presentation.screens

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quickorderapp.presentation.cards.MealCard

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val favorites by viewModel.favorites.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favorites, key = { it.id }) { meal ->
            var isVisible by remember { mutableStateOf(true) }

            AnimatedVisibility(
                visible = isVisible,
                exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it })
            ) {
                MealCard(
                    meal = meal,
                    onClick = { },
                    onFavoriteClick = {
                        isVisible = false
                        viewModel.removeFavorite(meal)
                    },
                    isFavorite = true
                )
            }
        }
    }
}
