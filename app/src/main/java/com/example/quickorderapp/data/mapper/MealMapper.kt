package com.example.quickorderapp.data.mappers

import com.example.quickorderapp.data.model.MealDto
import com.example.quickorderapp.domain.model.Meal

fun List<MealDto>.toDomainList(): List<Meal> {
    return this.map { mealDto ->
        Meal(
            id = (mealDto.idMeal.toIntOrNull() ?: 0).toString(),
            name = mealDto.strMeal,
            thumbnail = mealDto.strMealThumb,
            price = mealDto.strPrice ?: "N/A",
            description = mealDto.strDescription ?: "No description available"
        )
    }
}
