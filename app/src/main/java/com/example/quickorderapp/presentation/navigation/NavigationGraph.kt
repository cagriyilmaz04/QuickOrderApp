package com.example.quickorderapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickorderapp.presentation.screens.FavoritesScreen
import com.example.quickorderapp.presentation.screens.HomeScreen
import com.example.quickorderapp.presentation.screens.SplashScreen


@Composable
fun NavigationGraph(navController: NavHostController, onBottomBarVisibilityChanged: (Boolean) -> Unit) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            onBottomBarVisibilityChanged(false)
            SplashScreen(navController)
        }
        composable(Screen.Home.route) {
            onBottomBarVisibilityChanged(true)
            HomeScreen()
        }
        composable(Screen.Favorites.route) {
            onBottomBarVisibilityChanged(true)
            FavoritesScreen()
        }
    }
}