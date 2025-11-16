package com.example.quotesapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Horizontal pager

@Preview(showBackground = true)
@Composable
fun BannerSlider(modifier: Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { 5 }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.Red.copy(alpha = 0.8f)
                    )
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Slide: $page")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            repeat(pagerState.pageCount) { index ->
                val color = if (pagerState.currentPage == index) {
                    Color.Blue
                } else {
                    Color.Gray
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(12.dp)
                        .background(color, shape = CircleShape)
                ) {

                }
            }
        }
    }


}