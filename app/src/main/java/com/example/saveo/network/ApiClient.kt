package com.example.saveo.network


import com.example.saveo.model.Response
import com.example.saveo.model_saveo.ResponseSaveo
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiClient {

    @Headers("Accept: application/json")
    @GET("/search/shows?q=god")
    suspend fun getUsers(
        @Header("Content-Type") contentType:String
    ): ResponseSaveo
}