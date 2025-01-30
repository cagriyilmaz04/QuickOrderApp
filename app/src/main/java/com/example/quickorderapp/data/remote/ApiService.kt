package com.example.quickorderapp.data.remote

import com.example.quickorderapp.data.model.CategoryResponse
import com.example.quickorderapp.data.model.MealResponse
import com.example.quickorderapp.util.Constants.ENDPOINT_CATEGORIES
import com.example.quickorderapp.util.Constants.ENDPOINT_MEALS_BY_CATEGORY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ENDPOINT_CATEGORIES)
    suspend fun getCategories(): CategoryResponse

    @GET(ENDPOINT_MEALS_BY_CATEGORY)
    suspend fun getMealsByCategory(@Query("c") category: String): MealResponse
}
