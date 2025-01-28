package com.example.quickorderapp.data.remote

import com.example.quickorderapp.data.model.CategoryResponse
import com.example.quickorderapp.data.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealResponse
}