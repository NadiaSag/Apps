package com.nasch.apps.ConsumoAPIs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.R

class ConsumoApisAdapter (
    var movieList: List<movieDataResponse> = emptyList()
) : RecyclerView.Adapter<ConsumoApisViewHolder>() {

    fun updateList(list: List<movieDataResponse>) {
        movieList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumoApisViewHolder {
        return ConsumoApisViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount() = movieList.size


    override fun onBindViewHolder(holder: ConsumoApisViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}
