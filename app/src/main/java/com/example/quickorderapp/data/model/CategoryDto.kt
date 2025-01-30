package com.example.quickorderapp.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val thumbnail: String,
    @SerializedName("strCategoryDescription")
    val description: String
)
