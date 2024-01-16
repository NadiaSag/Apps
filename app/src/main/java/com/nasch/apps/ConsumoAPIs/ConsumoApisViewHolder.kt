package com.nasch.apps.ConsumoAPIs

import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class ConsumoApisViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieBinding.bind(view)
    fun bind(movieDataResponse: movieDataResponse) {
       // val titleText = "Title: ${movieDataResponse.title}"
        val genreText = "Genre: ${movieDataResponse.genre}"
        val yearText = "Year: ${movieDataResponse.year}"


        binding.tvTitle.text = movieDataResponse.title
        binding.tvGenre.text = genreText
        binding.tvYear.text = yearText
        Picasso.get().load(movieDataResponse.movieImageResponse).into(binding.ivMovie)

        binding.tvSource1.text = movieDataResponse.ratings[0].source
        binding.tvValue1.text = movieDataResponse.ratings[0].value

        binding.tvSource2.text = movieDataResponse.ratings[1].source
        binding.tvValue2.text = movieDataResponse.ratings[1].value

        binding.tvSource3.text = movieDataResponse.ratings[2].source
        binding.tvValue3.text = movieDataResponse.ratings[2].value

    }

}
