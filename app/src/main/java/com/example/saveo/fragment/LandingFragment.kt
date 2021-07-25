package com.example.saveo.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saveo.R
import com.example.saveo.adapter.MoviesHorizontalAdapter
import com.example.saveo.adapter.MovieVerticalAdapter
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.model_saveo.ResponseSaveoItem
import com.example.saveo.modelhorizontal.HorizonalClass
import com.example.saveo.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_landign.*

class LandingFragment : Fragment(), OnClickListenerMovies {

    private lateinit var movieHorizontalAdapter: MoviesHorizontalAdapter
    private lateinit var movieVerticalAdapter: MovieVerticalAdapter
    private var viewModel = MoviesViewModel()
    private var movieList : List<ResponseSaveoItem> = listOf()
    private var verticalList: List<HorizonalClass> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerviewAdapterHorizonatlly()
        setRecyclerviewAdapterVertically()

        setDataMeme()
    }

    private fun setRecyclerviewAdapterVertically() {
        movieVerticalAdapter = MovieVerticalAdapter(verticalList, this)
        val gridLayoutManager = GridLayoutManager(this.requireContext(),3)
        recycler_vertical.layoutManager = gridLayoutManager
        recycler_vertical.adapter = movieVerticalAdapter


    }

    private fun setDataMeme() {
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel:: class.java)
        viewModel.getMoviesData().observe(this.requireActivity(), Observer {
            var value = it
            movieHorizontalAdapter.updateList(value)
        })

        viewModel.getMovie2().observe(this.requireActivity(), Observer {
            movieVerticalAdapter.updateData(it)
        })
    }

    private fun setRecyclerviewAdapterHorizonatlly() {
        movieHorizontalAdapter = MoviesHorizontalAdapter(movieList)
        val linearLayoutManager = LinearLayoutManager(this.requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_horizontal.layoutManager = linearLayoutManager
        recycler_horizontal.adapter = movieHorizontalAdapter
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landign, container, false)
    }

    override fun onMovieClick(position: ResponseSaveoItem) {
//        Log.d(TAG, "Movie Clicked is ${position.show?.externals?.tvrage}")
//        goToMovieDetails(position)

    }




}