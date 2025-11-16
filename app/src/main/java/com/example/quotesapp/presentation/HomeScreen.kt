package com.example.quotesapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.quotesapp.model.Category
import com.example.quotesapp.model.Quote
import com.example.quotesapp.model.QuotesData
import com.example.quotesapp.ui.theme.Bold20
import com.example.quotesapp.ui.theme.Medium14
import com.example.quotesapp.ui.theme.Medium16
import com.example.quotesapp.ui.theme.Normal12
import com.example.quotesapp.ui.theme.Normal8

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToCategory: (category: String?) -> Unit,
    onNavigateToExplore: () -> Unit,
) {
    var quotes by remember { mutableStateOf(QuotesData.getAllQuotes()) }
    val categories = Category.getAll()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "Explore",
                style = MaterialTheme.typography.Bold20.copy(fontSize = 24.sp)
            )
            Text(
                "Awesome quotes from our community",
                style = MaterialTheme.typography.Normal12.copy(
                    color = Color.Black.copy(alpha = 0.8f)
                ),
            )
        }

//        item {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(8.dp))
//                    .height(400.dp)
//
//            ) {
//                BannerSlider(Modifier.fillMaxSize())
//            }
//        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxHeight(0.25f)
            ) {
                AsyncImage(
                    model = "https://i.pinimg.com/736x/1a/fd/3f/1afd3f3fd73871816c92cf7cdbbd449f.jpg",
                    contentDescription = "banner",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            SectionHeader(
                startText = "Latest Quotes",
                endText = "View All",
                onNavigate = {
                    onNavigateToExplore()
                }
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(quotes.take(10)) { quote ->
                    QuotesCard(
                        quote = quote,
                        onToggleSave = {
                            QuotesData.toggleSaveQuote(quote.id)
                            quotes = QuotesData.getAllQuotes()
                        }
                    )
                }
            }
        }

        item {
            SectionHeader(
                startText = "Categories",
                endText = "View All",
                onNavigate = {
                    onNavigateToExplore()
                }
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories) { category ->
                    QuotesCategoryComponent(
                        category = category,
                        onClick = { onNavigateToCategory(category.name) }
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun QuotesCategoryComponent(
    category: Category,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = category.color.copy(alpha = 0.08f))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(color = category.color.copy(alpha = 0.5f))
            ) {
                Icon(
                    category.icon,
                    contentDescription = "${category.name} Icon",
                    Modifier
                        .size(44.dp)
                        .padding(12.dp),
                    tint = category.color
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                category.name,
                style = MaterialTheme.typography.Medium14,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun QuotesCard(
    quote: Quote,
    onToggleSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryColor = Category.fromString(quote.category).color

    Card(
        modifier = modifier
            .width(200.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            categoryColor,
                            categoryColor.copy(alpha = 0.7f)
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircleShapeComponent(0.04f)
                SpacerWeight1f()
                IconButton(onClick = { /* Share */ }) {
                    Icon(
                        Icons.Default.Share,
                        contentDescription = "Share button",
                        tint = Color.White
                    )
                }
                IconButton(onClick = onToggleSave) {
                    Icon(
                        if (quote.isSaved) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite button",
                        tint = Color.White
                    )
                }
            }
            SpacerWeight1f()
            Text(
                text = quote.text,
                style = MaterialTheme.typography.Medium14.copy(
                    color = Color.White,
                    lineHeight = 16.sp
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "- ${quote.author}",
                style = MaterialTheme.typography.Normal8.copy(
                    color = Color.White,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun RowScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun ColumnScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun CircleShapeComponent(alpha: Float) {
    Surface(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape),
        color = Color.White.copy(alpha = alpha)
    ) {}
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    startText: String,
    endText: String,
    onNavigate: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = startText,
            style = MaterialTheme.typography.Medium16
        )
        Text(
            endText,
            style = MaterialTheme.typography.Medium16,
            modifier = Modifier.clickable {
                onNavigate()
            }
        )
    }
}