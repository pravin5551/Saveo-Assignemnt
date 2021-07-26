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
import com.example.saveo.adapter.MoviesAdapter
import com.example.saveo.adapter.MovieVerticalAdapter
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.model.MoviesResponse
import com.example.saveo.model_second_hori.TopRecycleClass
import com.example.saveo.viewModel.MovieShowDetailViewModel
import com.example.saveo.viewModel.MovieViewModel
import com.rahul.saveoapp.fragments.MovieFragment
import kotlinx.android.synthetic.main.fragment_landing.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the landing Home Fragment 
 * Here Im calling two recyclerviews One at top horizontally and another one at bottom vertically using grid layout
 */

class LandingFragment : Fragment(), OnClickListenerMovies {
    /*
    lateinit for future variable decleration
     */
    private lateinit var moviesAdapter: MoviesAdapter
    
    private lateinit var movieVerticalAdapter: MovieVerticalAdapter
    
    private var viewModel = MovieViewModel()
    private lateinit var movieShowDetailViewModel: MovieShowDetailViewModel
    
    private var movieList: List<MoviesResponse> = listOf()
    private var verticalList: List<TopRecycleClass> = listOf()
    /*
    variable for paging declaration
     */
    
    private var loading = true
    var VisibilityPostItem = 0
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
        HorizontalRecyclerView()
        VerticalRecyclerView()
        fetch_the_data()
    }

    /**
     * Vertical span count 3 recyclerview setup
     */

    private fun VerticalRecyclerView() {
        movieVerticalAdapter = MovieVerticalAdapter(verticalList, this)
        val gridLayoutManager = GridLayoutManager(this.context, 3)
        vertical_recyclerview.layoutManager = gridLayoutManager
        vertical_recyclerview.adapter = movieVerticalAdapter

        vertical_recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = gridLayoutManager.getChildCount()
                    totalItemCount = gridLayoutManager.getItemCount()
                    VisibilityPostItem = gridLayoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + VisibilityPostItem >= totalItemCount) {
                            loading = false
                            Log.v("...", "Last Item Wow !")
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.getMovieBottom()
                            }
                            loading = true
                        }
                    }
                }
            }
        })
    }

    /**
     * Gere i'm calling the API using ViewModel
     */
    private fun fetch_the_data() {
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.getMovieTop().observe(this.requireActivity(), Observer {
            moviesAdapter.updateData(it)
        })

        viewModel.getMovieBottom().observe(this.requireActivity(), Observer {
            verticalList = it
            movieVerticalAdapter.updateData(verticalList)
        })
    }

    /**
     * HorizontalRecyclerView recyclerview setup
     */
    
    private fun HorizontalRecyclerView() {
        moviesAdapter = MoviesAdapter(movieList)
        val linearLayoutManager = LinearLayoutManager(this.context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        horizontal_recyclerview.layoutManager = linearLayoutManager
        horizontal_recyclerview.adapter = moviesAdapter

        horizontal_recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = linearLayoutManager.getChildCount()
                    totalItemCount = linearLayoutManager.getItemCount()
                    VisibilityPostItem = linearLayoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + VisibilityPostItem >= totalItemCount) {
                            loading = false
                            Log.d("hello", "Last Item Wow !")
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.getMovieTop()
                            }
                            loading = true
                        }
                    }
                }
            }
        })



  
    }

    /**
     * Onclick of any movie new window will open i.e MovieFragment
     */

    override fun OnCLickDataPassing(position: Int) {
        movieShowDetailViewModel.getShow(verticalList[position])
        val movieFragment = MovieFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.flconatiner, movieFragment, "movieFragment").addToBackStack(null).commit()
    }

}