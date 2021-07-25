package com.example.saveo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.model_saveo.ResponseSaveoItem
import com.example.saveo.viewholder.MovieViewHolder

class MoviesAdapter(private var responseItemList: List<ResponseSaveoItem>): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_layout,parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val dataModel = responseItemList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return responseItemList.size
    }

    fun updateList(modelList:List<ResponseSaveoItem>){
        responseItemList = modelList
        notifyDataSetChanged()
    }
}


