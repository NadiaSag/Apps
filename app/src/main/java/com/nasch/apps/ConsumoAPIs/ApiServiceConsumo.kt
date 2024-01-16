package com.nasch.apps.ConsumoAPIs

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiServiceConsumo {
    @GET("/")
    suspend fun getMovie(@Query("t") movieName: String,
                         @Query("plot") plot: String = "full",
                         @Query("apikey") apiKey: String = "642b022c"): Response<movieDataResponse>
}
