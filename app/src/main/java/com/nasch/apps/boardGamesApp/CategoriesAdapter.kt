package com.nasch.apps.boardGamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.R

class CategoriesAdapter(private val categories: List<GameCategory>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    //llamamos al viewHolder desde aqui
    //alt intro y sale para implementar los métodos asociados
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected)

    }

    override fun getItemCount() =  categories.size
}