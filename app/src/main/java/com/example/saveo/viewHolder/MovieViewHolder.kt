package com.example.saveo.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveo.model.ShowClass
import kotlinx.android.synthetic.main.slider_item_layout.view.*

class MovieViewHolder(private val view: View) :
    RecyclerView.ViewHolder(view) {

    fun setData(showClass: ShowClass) {
        view.apply {
            Glide.with(movie_image).load(showClass.image!!.original).into(movie_image)
        }
    }
}