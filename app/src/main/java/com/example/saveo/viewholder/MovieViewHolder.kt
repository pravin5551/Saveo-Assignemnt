package com.example.saveo.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saveo.model_saveo.ResponseSaveoItem
import kotlinx.android.synthetic.main.slider_layout.view.*

class MovieViewHolder(private val view : View): RecyclerView.ViewHolder(view) {


    fun  setData(responseList: ResponseSaveoItem){
        view.apply {
            Glide.with(imageSlider).load(responseList.show?.image?.original).into(imageSlider)

        }
    }
}