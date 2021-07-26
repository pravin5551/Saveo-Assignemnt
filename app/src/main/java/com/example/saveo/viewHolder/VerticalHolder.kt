package com.example.saveo.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.model_second_hori.ImageClasss
import kotlinx.android.synthetic.main.vertical_slider_item.view.*

class VerticalHolder(private val view: View, private val onClickListenerMovies: OnClickListenerMovies) :
    RecyclerView.ViewHolder(view) {

    fun setData(imageClasss: ImageClasss) {
        view.apply {
            Glide.with(movie_image_vertical).load(imageClasss.original).into(movie_image_vertical)
        }
        view.setOnClickListener {
            onClickListenerMovies.OnCLickDataPassing(adapterPosition)
        }
    }
}