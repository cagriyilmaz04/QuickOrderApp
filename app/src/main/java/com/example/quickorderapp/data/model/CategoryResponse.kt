package com.example.quickorderapp.data.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categories")
    val categories: List<CategoryDto>
)
