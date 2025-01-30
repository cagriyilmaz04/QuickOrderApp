package com.example.quickorderapp.presentation.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.quickorderapp.domain.model.Category
import com.example.quickorderapp.util.Constants.CARD_ELEVATION
import com.example.quickorderapp.util.Constants.CORNER_RADIUS
import com.example.quickorderapp.util.Constants.GRID_ASPECT_RATIO
import com.example.quickorderapp.util.Constants.IMAGE_CORNER_RADIUS
import com.example.quickorderapp.util.Constants.IMAGE_SIZE
import com.example.quickorderapp.util.Constants.PADDING_MEDIUM
import com.example.quickorderapp.util.Constants.PADDING_SMALL

@Composable
fun CategoryGrid(
    categories: List<Category>,
    onItemClick: (Category) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(PADDING_SMALL),
            verticalArrangement = Arrangement.spacedBy(PADDING_MEDIUM),
            horizontalArrangement = Arrangement.spacedBy(PADDING_MEDIUM),
            modifier = Modifier.fillMaxSize().background(Color.White)
        ) {
            items(categories) { category ->
                CategoryCard(
                    category = category,
                    onClick = { onItemClick(category) }
                )
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: Category,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(CORNER_RADIUS),
        elevation = CardDefaults.elevatedCardElevation(CARD_ELEVATION),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(GRID_ASPECT_RATIO)
            .padding(PADDING_SMALL)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PADDING_MEDIUM),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Görsel
            Image(
                painter = rememberAsyncImagePainter(category.thumbnail),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(IMAGE_SIZE)
                    .clip(RoundedCornerShape(IMAGE_CORNER_RADIUS))
            )
            Spacer(modifier = Modifier.height(PADDING_MEDIUM))

            // Başlık
            Text(
                text = category.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
