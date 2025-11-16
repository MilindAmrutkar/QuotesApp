package com.example.quotesapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.quotesapp.QuotesScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = QuotesScreen.Home.route,
        modifier = modifier
    ) {
        composable(QuotesScreen.Home.route) {
            HomeScreen(
                onNavigateToCategory = { category ->
                    navController.navigate("${QuotesScreen.Explore.route}/$category")
                },
                onNavigateToExplore = {
                    navController.navigate("${QuotesScreen.Explore.route}/Motivation")
                }
            )
        }
        composable(
            route = "${QuotesScreen.Explore.route}/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    defaultValue = "Motivation"
                }
            )) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "Motivation"
            ExploreScreen(initialCategory = category)
        }

        composable(QuotesScreen.Explore.route) {
            ExploreScreen(initialCategory = "Motivation")
        }
        composable(QuotesScreen.Saved.route) {
            SavedScreen()
        }
    }
}