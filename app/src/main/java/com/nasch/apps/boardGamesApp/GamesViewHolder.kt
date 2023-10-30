package com.nasch.apps.boardGamesApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.R

class GamesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvGameName: TextView = view.findViewById(R.id.tvGame)
    private val cbGame: CheckBox = view.findViewById(R.id.cbGame)

    fun render(game: Game) {
        if (game.isSelected) {
            tvGameName.paintFlags = tvGameName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvGameName.paintFlags = tvGameName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbGame.isChecked = game.isSelected
        cbGame.setOnClickListener() {
            if (cbGame.isChecked) {
                tvGameName.paintFlags = tvGameName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                tvGameName.paintFlags = tvGameName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
            game.isSelected = cbGame.isChecked

        }

        tvGameName.text = game.name

        val color = when(game.category){
            GameCategory.Cooperative -> R.color.bgapp_cooperative_category
            GameCategory.Deckbuilding -> R.color.bgapp_deckbuilding_category
            GameCategory.LCG -> R.color.bgapp_lcg_category
            GameCategory.Euro -> R.color.bgapp_euro_category
            GameCategory.Legacy -> R.color.bgapp_legacy_category

        }

        cbGame.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbGame.context, color))
    }

}
