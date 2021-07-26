package com.example.saveo.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.saveo.model.MoviesResponse
import com.example.saveo.model_second_hori.TopRecycleClass
import com.example.saveo.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers



/**
 * This is a VM layer in the `MVVM` architecture, where we are notifying the Activity/view about the
 * response changes via live data
 */
class MovieViewModel : ViewModel() {

    private val repository = MoviesRepository()

    /**
     * Getting live data from server via repository- Horizontal
     */

    fun getMovieTop(): LiveData<List<MoviesResponse>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getListHorizontalMovies()
            emit(result.data!!)
        }
    }
    /**
     * Getting live data from server via repository- Vertical
     */
    fun getMovieBottom(): LiveData<List<TopRecycleClass>> {
        return liveData(Dispatchers.IO) {
            val result = repository.getListVerticalMovies()
            emit(result.data!!)
        }
    }
}