package com.example.saveo.repository


import com.example.saveo.model_saveo.ResponseSaveo
import com.example.saveo.modelhorizontal.HorizonalClass
import com.example.saveo.network.ApiClient
import com.example.saveo.network.Network
import com.example.saveo.network.Resource
import com.example.saveo.network.ResponseHandler


/**
 * This is a `M` layer in the `MVVM` architecture which gives us the data from the API
 */
class MoviesRepository {
    private val CONTENT_TYPE = "application/json"
    val apiClient = Network.getInstance() .create(ApiClient::class.java)
    val responseHandler = ResponseHandler()


    suspend fun getListOfMovies(): Resource<ResponseSaveo> {
        val call = apiClient.getTVMovies(CONTENT_TYPE)
        /*
       Once the response is fetched, navigate the user back to view model as this callback is being implemented
       in the Viewmodel class
        */
        return responseHandler.handleSuccess(call)
    }

    suspend fun getListOfMovies2(): Resource<List<HorizonalClass>> {
        val call = apiClient.getTVMoviesVertically(CONTENT_TYPE)
        /*
       Once the response is fetched, navigate the user back to view model as this callback is being implemented
       in the ViewModel class
        */
        return responseHandler.handleSuccess(call)
    }
}