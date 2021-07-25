package com.example.saveo.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.modelhorizontal.ImageClasss

import kotlinx.android.synthetic.main.vertical_item.view.*

class VerticalHolder(private val view: View, private val onClickListenerMovies: OnClickListenerMovies) :
    RecyclerView.ViewHolder(view) {

    fun setData(imageClasss: ImageClasss) {
        view.apply {
            Glide.with(showImage2).load(imageClasss.original).into(showImage2)
        }
        view.setOnClickListener {
            onClickListenerMovies.onMovieClick(adapterPosition)
        }
    }
}