package com.example.quickorderapp.presentation.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.quickorderapp.domain.model.Meal
import com.example.quickorderapp.util.Constants

@Composable
fun MealCard(
    meal: Meal,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    isFavorite: Boolean
) {
    Card(
        shape = RoundedCornerShape(Constants.CORNER_RADIUS),
        elevation = CardDefaults.elevatedCardElevation(Constants.CARD_ELEVATION),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F8F8)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_SMALL)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Constants.PADDING_MEDIUM),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(meal.thumbnail),
                contentDescription = meal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(Constants.IMAGE_SIZE_WIDTH)
                    .height(Constants.IMAGE_SIZE_HEIGHT)
                    .clip(RoundedCornerShape(Constants.IMAGE_CORNER_RADIUS))
            )
            Spacer(modifier = Modifier.width(Constants.PADDING_MEDIUM))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = meal.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(Constants.PADDING_SMALL))

                meal.description?.let {
                    Text(
                        text = it,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Start
                    )
                }

                Spacer(modifier = Modifier.height(Constants.PADDING_SMALL))

                meal.price?.let {
                    Text(
                        text = "Price: $it",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE67E22), // Turuncu fiyat
                        textAlign = TextAlign.Start
                    )
                }
            }

            androidx.compose.material3.Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (isFavorite) Color.Red else Color.Gray,
                modifier = Modifier
                    .width(Constants.ICON_SIZE)
                    .height(Constants.ICON_SIZE)
                    .clickable { onFavoriteClick() }
            )
        }
    }
}

@Composable
fun MealGrid(
    meals: List<Meal>,
    favorites: List<Meal>,
    onItemClick: (Meal) -> Unit,
    onFavoriteClick: (Meal) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(Constants.PADDING_SMALL),
        verticalArrangement = Arrangement.spacedBy(Constants.PADDING_SMALL),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
