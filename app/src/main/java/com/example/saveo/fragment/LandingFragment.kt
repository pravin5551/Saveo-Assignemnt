package com.example.saveo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.adapter.MoviesHorizontalAdapter
import com.example.saveo.adapter.MovieVerticalAdapter
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.model.ResponseClass
import com.example.saveo.model_second_hori.HorizonalClass
import com.example.saveo.viewModel.MovieShowDetailViewModel
import com.example.saveo.viewModel.MovieViewModel
import com.rahul.saveoapp.fragments.MovieFragment
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LandingFragment : Fragment(), OnClickListenerMovies {
    private lateinit var moviesHorizontalAdapter: MoviesHorizontalAdapter
    private lateinit var movieVerticalAdapter: MovieVerticalAdapter
    private var viewModel = MovieViewModel()
    private lateinit var movieShowDetailViewModel: MovieShowDetailViewModel
    private var movieList: List<ResponseClass> = listOf()
    private var verticalList: List<HorizonalClass> = listOf()
    private var loading = true
    var pastVisiblesItems = 0
    var visibleItemCount: Int = 0
    var totalItemCount: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieShowDetailViewModel = ViewModelProviders.of(requireActivity()).get(MovieShowDetailViewModel::class.java)
        setRecyclerView()
        hitApi()
    }

    private fun setRecyclerView() {
        moviesHorizontalAdapter = MoviesHorizontalAdapter(movieList)
        val linearLayoutManager = LinearLayoutManager(this.context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = moviesHorizontalAdapter

        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = linearLayoutManager.getChildCount()
                    totalItemCount = linearLayoutManager.getItemCount()
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Log.d("hello", "Last Item Wow !")
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.getMovie()
                            }
                            loading = true
                        }
                    }
                }
            }
        })



        movieVerticalAdapter = MovieVerticalAdapter(verticalList, this)
        val gridLayoutManager = GridLayoutManager(this.context, 3)
        verticalrecyclerview.layoutManager = gridLayoutManager
        verticalrecyclerview.adapter = movieVerticalAdapter

        verticalrecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = gridLayoutManager.getChildCount()
                    totalItemCount = gridLayoutManager.getItemCount()
                    pastVisiblesItems = gridLayoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Log.v("...", "Last Item Wow !")
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.getMovie2()
                            }
                            loading = true
                        }
                    }
                }
            }
        })
    }

    private fun hitApi() {
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.getMovie().observe(this.requireActivity(), Observer {
            moviesHorizontalAdapter.updateData(it)
        })

        viewModel.getMovie2().observe(this.requireActivity(), Observer {
            verticalList = it
            movieVerticalAdapter.updateData(verticalList)
        })
    }

    override fun onClick(position: Int) {
        movieShowDetailViewModel.getShowDetails(verticalList[position])
        val detailFragment = MovieFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.flconatiner, detailFragment, "detailFragment").addToBackStack(null).commit()
    }

}