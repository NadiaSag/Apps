package com.nasch.apps.ConsumoAPIs

import com.google.gson.annotations.SerializedName


data class movieDataResponse(
    @SerializedName("Title") val title: String?,
    @SerializedName("Year") val year: String?,
    @SerializedName("Genre") val genre: String?,
    @SerializedName("Poster") val movieImageResponse: String?,
    @SerializedName("Ratings") val ratings: List<movieRatings>
)


data class movieRatings(
    @SerializedName("Source") val source: String?,
    @SerializedName("Value") val value: String?,
)
