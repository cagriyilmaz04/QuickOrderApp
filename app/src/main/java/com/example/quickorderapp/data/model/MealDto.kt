package com.example.quickorderapp.data.model

import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
    @SerializedName("strPrice") val strPrice: String?,
    @SerializedName("strDescription") val strDescription: String?
)