package com.example.quickorderapp.data.remote

import com.example.quickorderapp.data.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CloudApiService {
    @GET("meals/{category}")
    suspend fun getMealsByCategory(@Path("category") category: String): MealResponse
}
