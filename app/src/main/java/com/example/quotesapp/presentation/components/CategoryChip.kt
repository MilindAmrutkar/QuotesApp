package com.example.quotesapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotesapp.ui.theme.Medium14

@Composable
fun CategoryChip(
    label: String,
    isSelected: Boolean,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        color = if (isSelected) color else Color.White,
        border = BorderStroke(1.dp, if (isSelected) color else Color(0xFFE5E7EB))
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.Medium14,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
    }
}