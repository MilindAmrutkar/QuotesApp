package com.example.quotesapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.quotesapp.model.Quote
import com.example.quotesapp.ui.theme.Medium14
import com.example.quotesapp.ui.theme.Medium16

@Composable
fun QuoteListItem(
    quote: Quote,
    categoryColor: Color,
    onToggleSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        // Main content row: Avatar + Text side by side
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Avatar - fixed width, stays on left
            Surface(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
                color = Color(0xFFE5E7EB)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "User avatar",
                        tint = Color(0xFF3B82F6),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            // Text content - fills remaining width
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Category tag aligned to the right
                Text(
                    text = quote.category,
                    style = MaterialTheme.typography.Medium14,
                    color = categoryColor,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.End
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Quote text
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.Medium16,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Author name
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.Medium14,
                    color = Color(0xFFEA580C),
                    fontStyle = FontStyle.Italic
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Action buttons row - indented to align with text
        Row(
            modifier = Modifier.padding(start = 68.dp), // Avatar size + spacing
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Save/Like button
            Surface(
                onClick = onToggleSave,
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = Color(0xFFF3F4F6)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = if (quote.isSaved) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Save",
                        tint = if (quote.isSaved) Color(0xFFEF4444) else Color(0xFF9CA3AF),
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // Share button
            Surface(
                onClick = { /* Share */ },
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = Color(0xFFD1FAE5)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color(0xFF10B981),
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // Download button
            Surface(
                onClick = { /* Download */ },
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = Color(0xFFFFEDD5)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Filled.FileDownload,
                        contentDescription = "Download",
                        tint = Color(0xFFEA580C),
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        HorizontalDivider(color = Color(0xFFE5E7EB), thickness = 1.dp)
    }
}