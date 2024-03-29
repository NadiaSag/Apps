package com.nasch.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.nasch.apps.ConsumoAPIs.ActivityConsumoAPIs
import com.nasch.apps.IMC.IMC
import com.nasch.apps.Settings.SettingsActivity
import com.nasch.apps.SuperheroListActivity.SuperheroActivity
import com.nasch.apps.boardGamesApp.boardGamesActivity
import com.nasch.apps.colorPalette.ColorPalette


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }


        var btnHello = findViewById<Button>(R.id.btnHola)
        btnHello.setOnClickListener { navigateToHola() }

        var btnIMC = findViewById<Button>(R.id.btnIMC)
        btnIMC.setOnClickListener { navigateToIMC() }

        var btnboardGamesActivity = findViewById<Button>(R.id.btnBoardGames)
        btnboardGamesActivity.setOnClickListener { navigateBoardGamesApp() }

        var btnColorPalette = findViewById<Button>(R.id.btnColorPalette)
        btnColorPalette.setOnClickListener { navigateToColorPalette() }

        var btnSuperHerosApp = findViewById<Button>(R.id.btnSuperHerosApp)
        btnSuperHerosApp.setOnClickListener { navigateToSuper() }


        var btnMovie = findViewById<Button>(R.id.btnMovie)
        btnMovie.setOnClickListener { navigateToMovieApp() }

        var btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSettings.setOnClickListener { navigateToSettingsApp() }

    }

    private fun navigateToSettingsApp() {
        var intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMovieApp() {
        var intent = Intent(this, ActivityConsumoAPIs::class.java)
        startActivity(intent)
    }

    private fun navigateToSuper() {
        var intent = Intent(this, SuperheroActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToColorPalette() {
        var intent = Intent(this, ColorPalette::class.java)
        startActivity(intent)
    }

    private fun navigateToIMC() {
        var intent = Intent(this, IMC::class.java)
        startActivity(intent)
    }

    private fun navigateToHola() {
        var intent = Intent(this, Hola::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, IMC::class.java)
        startActivity(intent)
    }

    private fun navigateBoardGamesApp() {
        var intent = Intent(this, boardGamesActivity::class.java)
        startActivity(intent)
    }

}
