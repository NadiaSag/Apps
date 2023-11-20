package com.nasch.apps.colorPalette

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.R

class VerticalBarsViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val tvH: TextView = view.findViewById(R.id.tvH)
    private val cardViewContainer: CardView = view.findViewById(R.id.cardViewContainer)

    fun render(verticalBarsList: VerticalBar) {
        when (verticalBarsList.name) {
            R.string.v1_20.toString() -> {
                tvH.text = "V1 (20%)"
                cardViewContainer.setCardBackgroundColor(verticalBarsList.color)
            }
            R.string.v2_35.toString() -> {
                tvH.text = "V2 (35%)"
                cardViewContainer.setCardBackgroundColor(verticalBarsList.color)
            }

            R.string.v3_50.toString() -> {
                tvH.text = "V3 (50%)"
                cardViewContainer.setCardBackgroundColor(verticalBarsList.color)
            }

            R.string.v4_65.toString() -> {
                tvH.text = "V4 (65%)"
                cardViewContainer.setCardBackgroundColor(verticalBarsList.color)
            }

            R.string.v5_80.toString() -> {
                tvH.text = "V5 (80%)"
                cardViewContainer.setCardBackgroundColor(verticalBarsList.color)
            }

        }
    }
}