package com.example.quotesapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val name: String,
    val icon: ImageVector,
    val color: Color,
) {
    companion object {
        val Life = Category(name = "Life", Icons.Default.Favorite, Color(0xFF3B82F6))
        val Motivation = Category("Motivation", Icons.Default.Star, Color(0xFFEA580C))
        val Success = Category("Success", Icons.Default.ThumbUp, Color(0xFF10B981))
        val Wisdom = Category("Wisdom", Icons.Default.Favorite, Color(0xFF8B5CF6))
        val Love = Category("Love", Icons.Default.Favorite, Color(0xFFEC4899))

        fun getAll() = listOf(Life, Motivation, Success, Wisdom, Love)

        fun fromString(name: String): Category {
            return when (name.lowercase()) {
                "life" -> Life
                "motivation" -> Motivation
                "success" -> Success
                "wisdom" -> Wisdom
                "love" -> Love
                else -> Life
            }
        }
    }
}
