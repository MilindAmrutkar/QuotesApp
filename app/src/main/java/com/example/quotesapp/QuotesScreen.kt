package com.example.quotesapp

sealed class QuotesScreen(val route: String) {
    data object Home: QuotesScreen("home")
    data object Explore: QuotesScreen("explore")
    data object Saved: QuotesScreen("saved")
}