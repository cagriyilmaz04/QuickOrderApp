package com.example.quickorderapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.quickorderapp.presentation.screens.FavoritesScreen
import com.example.quickorderapp.presentation.screens.HomeScreen
import com.example.quickorderapp.presentation.screens.MealScreen
import com.example.quickorderapp.presentation.screens.SplashScreen


@Composable
fun NavigationGraph(navController: NavHostController,  onDestinationChanged: (Boolean) -> Unit) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            onDestinationChanged(false)
            SplashScreen(navController)
        }
        composable(Screen.Home.route) {
            onDestinationChanged(true)
            HomeScreen(navController)
        }
        composable(Screen.Favorites.route) {
            onDestinationChanged(true)
            FavoritesScreen()
        }
        composable(
            route = Screen.Meal.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.StringType },
                navArgument("categoryName") { type = NavType.StringType },
                navArgument("categoryThumbnail") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName")


            MealScreen(
                category = categoryName.toString()
            )
        }
    }
}
