package com.example.quickorderapp.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
        startDestination = Screen.Splash.route,
        enterTransition = { fadeIn(animationSpec = tween(700)) },
        exitTransition = { fadeOut(animationSpec = tween(700)) }
    ) {
        composable(
            route = Screen.Splash.route,
            enterTransition = { fadeIn(animationSpec = tween(500)) },
            exitTransition = { fadeOut(animationSpec = tween(500)) }
        ) {
            onDestinationChanged(false)
            SplashScreen(navController)
        }

        composable(
            route = Screen.Home.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(500)) }
        ) {
            onDestinationChanged(true)
            HomeScreen(navController)
        }

        composable(
            route = Screen.Favorites.route,
            enterTransition = { slideInVertically(initialOffsetY = { 1000 }, animationSpec = tween(500)) },
            exitTransition = { slideOutVertically(targetOffsetY = { -1000 }, animationSpec = tween(500)) }
        ) {
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
