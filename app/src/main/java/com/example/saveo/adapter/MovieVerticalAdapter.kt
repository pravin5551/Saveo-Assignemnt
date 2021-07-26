package com.example.saveo.adapter

/**
 * In this adapter class im binding the view to the vertical_slider_item
 *
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveo.R
import com.example.saveo.interfaceClass.OnClickListenerMovies
import com.example.saveo.model_second_hori.TopRecycleClass
import com.example.saveo.viewHolder.VerticalHolder

class MovieVerticalAdapter(
    private var showList: List<TopRecycleClass>,
    private val onClickListenerMovies: OnClickListenerMovies
) :
    RecyclerView.Adapter<VerticalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vertical_slider_item, parent, false)
        return VerticalHolder(view, onClickListenerMovies)
    }

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        val showLists = showList[position].image
        holder.setData(showLists!!)
    }

    override fun getItemCount(): Int {
        return showList.size
    }
    /**
     * Updating new fetched data to list and notifying to the adapter that data has changes
     */
    fun updateData(showList: List<TopRecycleClass>) {
        this.showList = showList
        notifyDataSetChanged()
    }
}