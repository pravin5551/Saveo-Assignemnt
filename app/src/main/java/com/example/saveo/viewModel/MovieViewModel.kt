package com.example.saveo.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.saveo.model.ResponseClass
import com.example.saveo.model_second_hori.HorizonalClass
import com.example.saveo.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers



/**
 * This is a VM layer in the `MVVM` architecture, where we are notifying the Activity/view about the
 * response changes via live data
 */
class MovieViewModel : ViewModel() {

    private val repository = MoviesRepository()

    fun getMovie(): LiveData<List<ResponseClass>> {
        return liveData(Dispatchers.IO) {
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