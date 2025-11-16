package com.example.quotesapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotesapp.model.Category
import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.presentation.components.QuoteListItem
import com.example.quotesapp.ui.theme.Bold20

@Composable
fun SavedScreen(modifier: Modifier = Modifier) {
    var savedQuotes by remember { mutableStateOf(QuotesData.getSavedQuotes()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Saved Quotes",
            style = MaterialTheme.typography.Bold20
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (savedQuotes.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No saved quotes yet")
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(savedQuotes) { quote ->
                    val categoryColor = Category.fromString(quote.category).color
                    QuoteListItem(
                        quote = quote,
                        categoryColor = categoryColor,
                        onToggleSave = {
                            QuotesData.toggleSaveQuote(quote.id)
                            savedQuotes = QuotesData.getSavedQuotes()
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}