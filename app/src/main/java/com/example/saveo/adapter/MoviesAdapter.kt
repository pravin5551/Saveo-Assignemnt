package com.example.saveo.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.model.MoviesResponse
import com.example.saveo.viewHolder.MovieViewHolder

/**
 * In this adapter class im binding the view to the slider_item_layout
 *
 */

class MoviesAdapter(
    private var showList: List<MoviesResponse>,
) :
    RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_item_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val showLists = showList[position].show!!
        holder.setData(showLists)
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    /**
     * Updating new fetched data to list and notifying to the adapter that data has changes
     */

    fun updateData(showList: List<MoviesResponse>) {
        this.showList = showList
        notifyDataSetChanged()
    }
}