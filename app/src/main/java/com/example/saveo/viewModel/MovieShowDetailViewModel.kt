package com.example.saveo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saveo.model_second_hori.HorizonalClass

class MovieShowDetailViewModel : ViewModel() {

    private var showDetails = MutableLiveData<HorizonalClass>()

    fun getShowDetails(details: HorizonalClass) {
        showDetails.value = details
    }

    fun showShowDetails(): MutableLiveData<HorizonalClass> {
        return showDetails
    }

}