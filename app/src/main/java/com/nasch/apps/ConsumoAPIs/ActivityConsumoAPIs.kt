package com.nasch.apps.ConsumoAPIs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasch.apps.R
import com.nasch.apps.databinding.ActivityConsumoApisBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityConsumoAPIs : AppCompatActivity() {
    private var movieListMutable = mutableListOf<movieDataResponse>()
    private lateinit var binding: ActivityConsumoApisBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: ConsumoApisAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo_apis)
        binding = ActivityConsumoApisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    searchByName(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String?) = false
            //https://www.omdbapi.com/?t=it&plot=full&apikey=642b022c
        })

        adapter = ConsumoApisAdapter(emptyList())
        binding.rvItem.setHasFixedSize(true)
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvItem.adapter = adapter

    }

    private fun searchByName(query: String) {

        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                movieListMutable.clear()

                val myResponse: Response<movieDataResponse> = retrofit.create(ApiServiceConsumo::class.java).getMovie(query)
                if (myResponse.isSuccessful) {
                    Log.i("Consulta", "Funciona :)")
                    val response: movieDataResponse? = myResponse.body()
                    if (response != null) {
                        Log.i("Cuerpo de la consulta", response.toString())
                        runOnUiThread {
                            // Actualiza la interfaz de usuario con los datos de la respuesta
                            // Asegúrate de tener un método en tu adaptador para actualizar la lista
                            // adapter.updateList(response.movies)
                            movieListMutable.add(response)
                            adapter.updateList(movieListMutable)
                            binding.progressBar.isVisible = false
                        }
                    }
                } else {
                    Log.i("Consulta", "No funciona :(")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}