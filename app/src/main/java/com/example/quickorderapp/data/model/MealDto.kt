package com.example.quickorderapp.data.model

import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strMealThumb")
    val thumbnail: String
)
