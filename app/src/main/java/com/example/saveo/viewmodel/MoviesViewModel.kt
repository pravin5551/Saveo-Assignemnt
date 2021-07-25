package com.example.saveo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.saveo.model.Response
import androidx.lifecycle.liveData
import com.example.saveo.model_saveo.ResponseSaveo
import com.example.saveo.modelhorizontal.HorizonalClass
import com.example.saveo.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers

/**
 * This is a VM layer in the `MVVM` architecture, where we are notifying the Activity/view about the
 * response changes via live data
 */
class MoviesViewModel: ViewModel(){

    val repository = MoviesRepository()

    fun getMoviesData(): LiveData<ResponseSaveo>{
        return liveData(Dispatchers.IO){
            val result = repository.getListOfMovies()
            emit(result.data!!)
        }
    }

    fun getMovie2(): LiveData<List<HorizonalClass>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getListOfMovies2()
            emit(result.data!!)
        }
    }
}