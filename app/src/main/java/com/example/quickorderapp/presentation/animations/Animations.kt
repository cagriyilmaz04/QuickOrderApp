package com.example.quickorderapp.presentation.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AnimatedLoading() {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier.scale(scale)
        )
    }
}

@Composable
fun AnimatedCategoryGrid(
    categories: List<com.example.quickorderapp.domain.model.Category>,
    onItemClick: (com.example.quickorderapp.domain.model.Category) -> Unit
) {
    AnimatedVisibility(
        visible = categories.isNotEmpty(),
        enter = fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.8f),
        exit = fadeOut(animationSpec = tween(300))
    ) {
        com.example.quickorderapp.presentation.cards.CategoryGrid(
            categories = categories,
            onItemClick = onItemClick
        )
    }
}

@Composable
fun AnimatedErrorMessage(message: String) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(300)),
        exit = fadeOut(animationSpec = tween(300))
    ) {
        Text(
            text = message,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}
