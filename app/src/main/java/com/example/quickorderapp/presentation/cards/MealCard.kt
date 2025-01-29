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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
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
    onFavoriteClick: () -> Unit,
    isFavorite: Boolean
) {
    Card(
        shape = RoundedCornerShape(16.dp), // Yuvarlatılmış köşeler
        elevation = CardDefaults.elevatedCardElevation(8.dp), // Gölge efekti
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color(0xFFF8F8F8) // Kartın arka plan rengi
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) // Kartın çevresine boşluk
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically // Dikeyde ortalanır
        ) {
            // Görsel
            Image(
                painter = rememberAsyncImagePainter(meal.thumbnail),
                contentDescription = meal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .height(82.dp)
                    .clip(RoundedCornerShape(8.dp)) // Yuvarlatılmış görsel
            )
            Spacer(modifier = Modifier.width(16.dp)) // Görsel ile metin arasında boşluk

            // Yemek İsmi
            Column(
                modifier = Modifier.weight(1f) // Kalan alanı kaplar
            ) {
                Text(
                    text = meal.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.Black // Metin rengi
                )
            }

            // Favori İkonu
            androidx.compose.material3.Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (isFavorite) androidx.compose.ui.graphics.Color.Red else androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable { onFavoriteClick() }
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
