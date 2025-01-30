package com.example.quickorderapp.data.remote

import com.example.quickorderapp.data.model.CategoryResponse
import com.example.quickorderapp.util.Constants.ENDPOINT_CATEGORIES
import retrofit2.http.GET

interface TheMealDBApiService {
    @GET(ENDPOINT_CATEGORIES)
    suspend fun getCategories(): CategoryResponse
}
