package com.example.saveo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.modelhorizontal.HorizonalClass
import com.example.saveo.viewholder.VerticalHolder

class MovieVerticalAdapter(
    private var showList: List<HorizonalClass>,
    private val onClickListenerMovies: OnClickListenerMovies
) :
    RecyclerView.Adapter<VerticalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vertical_item, parent, false)
        return VerticalHolder(view, onClickListenerMovies)
    }

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        val showLists = showList[position].image
        holder.setData(showLists!!)
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    fun updateData(showList: List<HorizonalClass>) {
        this.showList = showList
        notifyDataSetChanged()
    }
}