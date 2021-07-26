package com.example.saveo.network


import com.example.saveo.model.MoviesResponse
import com.example.saveo.model_second_hori.TopRecycleClass
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiClient {
    /**
     * This @Get for Horizontal Recyclerview
     */
    @Headers("Accept: application/json")
    @GET("search/shows?q=god")
    suspend fun getHorizontralData(
        @Header("Content-Type") contentType: String
    ): List<MoviesResponse>

    /**
     * This @Get for Vertical Recyclerview
     */
    @Headers("Accept: application/json")
    @GET("shows?page=1")
    suspend fun getVerticalData(
        @Header("Content-Type") contentType: String
    ): List<TopRecycleClass>
}