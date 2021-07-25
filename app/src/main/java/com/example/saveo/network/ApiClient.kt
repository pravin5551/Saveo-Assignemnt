package com.example.saveo.network



import com.example.saveo.model_saveo.ResponseSaveo
import com.example.saveo.modelhorizontal.HorizonalClass
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiClient {

    @Headers("Accept: application/json")
    @GET("/search/shows?q=god")
    suspend fun getTVMovies(
        @Header("Content-Type") contentType:String
    ): ResponseSaveo

    @Headers("Accept: application/json")
    @GET("shows?page=1")
    suspend fun getTVMoviesVertically(
        @Header("Content-Type") contentType: String
    ): List<HorizonalClass>
}