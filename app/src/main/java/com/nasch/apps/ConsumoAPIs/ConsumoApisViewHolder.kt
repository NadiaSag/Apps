package com.nasch.apps.ConsumoAPIs

import android.annotation.SuppressLint
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class ConsumoApisViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieBinding.bind(view)
    private val listOfTexts = mutableListOf(
        binding.tvGenre, binding.tvYear, binding.tvSource1,
        binding.tvValue1, binding.tvSource2, binding.tvValue2,
        binding.tvSource3, binding.tvValue3
    )

    @SuppressLint("SuspiciousIndentation")
    fun bind(movieDataResponse: movieDataResponse) {
        // Establece los valores predeterminados "N/A" para limpiar cualquier valor anterior
        binding.tvSource1.text = " "
        binding.tvValue1.text = " "
        binding.tvSource2.text = " "
        binding.tvValue2.text = " "
        binding.tvSource3.text = " "
        binding.tvValue3.text = " "

        Picasso.get().cancelRequest(binding.ivMovie)
        Picasso.get().load(movieDataResponse.movieImageResponse).into(binding.ivMovie)

        if (movieDataResponse.title != null) {
            val genreText = "Genre: ${movieDataResponse.genre}"
            val yearText = "Year: ${movieDataResponse.year}"
            binding.tvTitle.text = movieDataResponse.title
            binding.tvGenre.text = genreText
            binding.tvYear.text = yearText
            binding.tvratings.text = "Ratings"

            for (i in 0 until minOf(movieDataResponse.ratings.size, 3)) {
                val rating = movieDataResponse.ratings[i]
                val sourceText = rating.source ?: "N/A"
                val valueText = rating.value ?: "N/A"

                when (i) {
                    0 -> {
                        binding.tvSource1.text = sourceText
                        binding.tvValue1.text = valueText
                    }
                    1 -> {
                        binding.tvSource2.text = sourceText
                        binding.tvValue2.text = valueText
                    }
                    2 -> {
                        binding.tvSource3.text = sourceText
                        binding.tvValue3.text = valueText
                    }
                }
            }
        } else {
            binding.tvTitle.text = "Ooopss it seems this movie does not exist"
            binding.tvGenre.text = ""
            binding.tvYear.text = ""
            binding.tvratings.text = ""

            listOfTexts.forEach { textView ->
                textView.text = ""
            }
        }
    }



}