package com.example.quotesapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotesapp.model.Category
import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.presentation.components.CategoryChip
import com.example.quotesapp.presentation.components.QuoteListItem
import com.example.quotesapp.ui.theme.Bold20

@Composable
fun ExploreScreen(
    initialCategory: String? = null,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(initialCategory ?: "Motivation") }
    var quotes by remember(selectedCategory) {
        mutableStateOf(QuotesData.getQuotesByCategory(selectedCategory))
    }
    val categories = Category.getAll()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Categories",
                style = MaterialTheme.typography.Bold20
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
               items(categories) { category ->
                   CategoryChip(
                       label = category.name,
                       isSelected = category.name == selectedCategory,
                       color = category.color,
                       onClick = {
                           selectedCategory = category.name
                           quotes = QuotesData.getQuotesByCategory(category.name)
                       }
                   )
               }
            }
        }

        items(quotes) { quote ->
            val categoryColor = Category.fromString(quote.category).color
            QuoteListItem(
                quote = quote,
                categoryColor = categoryColor,
                onToggleSave = {
                    QuotesData.toggleSaveQuote(quote.id)
                    quotes = QuotesData.getQuotesByCategory(selectedCategory)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}























