package com.nasch.apps.colorPalette

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.R

class VerticalBarsAdapter(var verticalBars: List<VerticalBar>) :
    RecyclerView.Adapter<VerticalBarsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalBarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_color, parent, false)
        return VerticalBarsViewHolder(view)
    }

    override fun getItemCount() = verticalBars.size

    override fun onBindViewHolder(holder: VerticalBarsViewHolder, position: Int) {
        holder.render(verticalBars[position])
    }

}
