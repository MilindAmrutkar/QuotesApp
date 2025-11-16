package com.example.quotesapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.quotesapp.QuotesScreen

@Composable
fun BottomNavBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color(0xFF1E40AF)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentRoute == QuotesScreen.Home.route,
            onClick = { onNavigate(QuotesScreen.Home.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Explore") },
            label = { Text("Explore") },
            selected = currentRoute?.startsWith(QuotesScreen.Explore.route) == true,
            onClick = { onNavigate("${QuotesScreen.Explore.route}/Motivation") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Saved") },
            label = { Text("Saved") },
            selected = currentRoute == QuotesScreen.Saved.route,
            onClick = { onNavigate(QuotesScreen.Saved.route) }
        )
    }
}