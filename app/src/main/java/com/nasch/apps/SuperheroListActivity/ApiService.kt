package com.nasch.apps.SuperheroListActivity

import com.nasch.apps.SuperheroListActivity.SuperHeroDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/4225765517649804/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperHeroDataResponse>
    abstract fun getSuperheroDetail(id: String): Any

    //@GET("/api/4225765517649804/{id}")
    //suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<SuperHeroDetailResponse>

}