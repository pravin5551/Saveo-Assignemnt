package com.example.saveo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.adapter.MoviesAdapter
import com.example.saveo.model_saveo.ResponseSaveoItem
import com.example.saveo.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_landign.*


class LandingFragment : Fragment() {

    private lateinit var movieAdapter: MoviesAdapter
    private var viewModel = MoviesViewModel()
    private var movieList : List<ResponseSaveoItem> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerviewAdapter()
        setDataMeme()
    }

    private fun setDataMeme() {
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel:: class.java)
        viewModel.getMoviesData().observe(this.requireActivity(), Observer {
            var value = it
            movieAdapter.updateList(value)
        })
    }

    private fun setRecyclerviewAdapter() {
        movieAdapter = MoviesAdapter(movieList)
        val linearLayoutManager = LinearLayoutManager(this.requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_horizontal.layoutManager = linearLayoutManager
        recycler_horizontal.adapter = movieAdapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landign, container, false)
    }


}