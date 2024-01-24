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
        binding.tvGenre, binding.tvYear, binding.tvSource1, binding.tvratings,
        binding.tvValue1, binding.tvSource2, binding.tvValue2,
        binding.tvSource3, binding.tvValue3
    )

    @SuppressLint("SuspiciousIndentation")
    fun bind(movieDataResponse: movieDataResponse) {
        Picasso.get().cancelRequest(binding.ivMovie)
        Picasso.get().load(movieDataResponse.movieImageResponse).into(binding.ivMovie)
        if(movieDataResponse.title!=null){
        // val titleText = "Title: ${movieDataResponse.title}"
        val genreText = "Genre: ${movieDataResponse.genre}"
        val yearText = "Year: ${movieDataResponse.year}"
        binding.tvTitle.text = movieDataResponse.title
        binding.tvGenre.text = genreText
        binding.tvYear.text = yearText

            if (movieDataResponse.ratings != null && movieDataResponse.ratings.size >= 3) {

                binding.tvSource1.text = movieDataResponse.ratings[0].source ?: "N/A"
                binding.tvValue1.text = movieDataResponse.ratings[0].value ?: "N/A"

                binding.tvSource2.text = movieDataResponse.ratings[1].source ?: "N/A"
                binding.tvValue2.text = movieDataResponse.ratings[1].value ?: "N/A"

                binding.tvSource3.text = movieDataResponse.ratings[2].source ?: "N/A"
                binding.tvValue3.text = movieDataResponse.ratings[2].value ?: "N/A"
            } else {
                // Handle the case when ratings is null or has less than 3 elements
                // You can set default values or handle it according to your app's logic
                binding.tvSource1.text = "N/A"
                binding.tvValue1.text = "N/A"

                binding.tvSource2.text = "N/A"
                binding.tvValue2.text = "N/A"

                binding.tvSource3.text = "N/A"
                binding.tvValue3.text = "N/A"
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

