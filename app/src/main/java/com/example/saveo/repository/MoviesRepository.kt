package com.example.saveo.repository

import com.example.saveo.model.MoviesResponse
import com.example.saveo.model_second_hori.TopRecycleClass
import com.example.saveo.network.ApiClient
import com.example.saveo.network.Network
import com.example.saveo.network.Resource
import com.example.saveo.network.ResponseHandler


/**
 * This is a `M` layer in the `MVVM` architecture which gives us the data from the API
 */
class MoviesRepository {
    private val CONTENT_TYPE = "application/json"
    val apiClient = Network.getInstance().create(ApiClient::class.java)
    val responseHandler = ResponseHandler()

    suspend fun getListHorizontalMovies(): Resource<List<MoviesResponse>> {
        val call = apiClient.getHorizontralData(CONTENT_TYPE)
        /*
       Once the response is fetched, navigate the user back to view model as this callback is being implemented
       in the ViewModel class
        */
        return responseHandler.handleSuccess(call)
    }

    suspend fun getListVerticalMovies(): Resource<List<TopRecycleClass>> {
        val call = apiClient.getVerticalData(CONTENT_TYPE)
        /*
       Once the response is fetched, navigate the user back to view model as this callback is being implemented
       in the ViewModel class
        */
        return responseHandler.handleSuccess(call)
    }
}