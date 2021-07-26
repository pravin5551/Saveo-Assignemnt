package com.example.saveo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saveo.model_second_hori.TopRecycleClass

class MovieShowDetailViewModel : ViewModel() {

    private var showDetails = MutableLiveData<TopRecycleClass>()

    fun getShow(details: TopRecycleClass) {
        showDetails.value = details
    }

    fun showShow(): MutableLiveData<TopRecycleClass> {
        return showDetails
    }

}