package com.example.quickorderapp.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.quickorderapp.R


sealed class Screen(val route: String, val title: String, val icon: ImageVector?) {
    object Splash : Screen("splash", "Splash",icon = null)
    object Home : Screen("home", "Home", Icons.Outlined.Home)
    object Favorites : Screen("favorites", "Favorites", Icons.Outlined.Favorite)
}