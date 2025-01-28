package com.example.quickorderapp.presentation.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.quickorderapp.domain.model.Meal

@Composable
fun MealCard(
    meal: Meal,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit, // Favori tıklama işlevi
    isFavorite: Boolean // Favori durumu
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxWidth() // Kart tam genişlikte olacak
            .padding(horizontal = 8.dp) // Kartın yan taraflarında boşluk
            .clickable { onClick() } // Kart tıklama
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically // Dikeyde ortalama
        ) {
            // Görsel
            Image(
                painter = rememberAsyncImagePainter(meal.thumbnail),
                contentDescription = meal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .aspectRatio(1f) // Görsel kare boyutunda olacak
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = meal.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            androidx.compose.material3.Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (isFavorite) androidx.compose.ui.graphics.Color.Red else androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier
                    .clickable { onFavoriteClick() } // Favori tıklama
            )
        }
    }
}


@Composable
fun MealGrid(
    meals: List<Meal>,
    favorites: List<Meal>, // Favoriler listesi
    onItemClick: (Meal) -> Unit,
    onFavoriteClick: (Meal) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(meals) { meal ->
            val isFavorite = favorites.contains(meal)
            MealCard(
                meal = meal,
                onClick = { onItemClick(meal) },
                isFavorite = isFavorite,
                onFavoriteClick = { onFavoriteClick(meal) }
            )
        }
    }
}
