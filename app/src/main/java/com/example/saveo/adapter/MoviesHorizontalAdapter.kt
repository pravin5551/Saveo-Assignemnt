package com.example.saveo.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.model.ResponseClass
import com.example.saveo.viewHolder.MovieViewHolder


class MoviesHorizontalAdapter(
    private var showList: List<ResponseClass>,
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

    fun updateData(showList: List<ResponseClass>) {
        this.showList = showList
        notifyDataSetChanged()
    }
}