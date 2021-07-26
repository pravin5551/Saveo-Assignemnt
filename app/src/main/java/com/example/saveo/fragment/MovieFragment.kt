package com.rahul.saveoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.saveo.R

import com.example.saveo.model_second_hori.HorizonalClass
import com.example.saveo.viewModel.MovieShowDetailViewModel
import kotlinx.android.synthetic.main.fragment_movies.*


class MovieFragment : Fragment() {
    private lateinit var movieShowDetailViewModel: MovieShowDetailViewModel
    private lateinit var verticalList: HorizonalClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieShowDetailViewModel = ViewModelProviders.of(requireActivity()).get(MovieShowDetailViewModel::class.java)
        movieShowDetailViewModel.showShowDetails().observe(this.requireActivity(), Observer {
            verticalList = it
            setData()
        })

    }

    private fun setData() {
        Glide.with(imgShowImage).load(verticalList.image!!.original).into(imgShowImage)
        tvShowName.text = verticalList.name
        tvRating.text = verticalList.language
        tvTime.text = verticalList.runtime.toString()
        tvDate.text = verticalList.premiered
        tvDesciption.text = verticalList.summary

    }

}