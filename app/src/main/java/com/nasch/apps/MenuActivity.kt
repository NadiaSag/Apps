package com.nasch.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.nasch.apps.IMC.IMC
import com.nasch.apps.boardGamesApp.boardGamesActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }

        var btnHello = findViewById<Button>(R.id.btnHola)
        btnHello.setOnClickListener{ navigateToHola () }

        var btnIMC = findViewById<Button>(R.id.btnIMC)
        btnIMC.setOnClickListener{ navigateToIMC () }

        var btnboardGamesActivity = findViewById<Button>(R.id.btnBoardGames)
        btnboardGamesActivity.setOnClickListener{ navigateBoardGamesApp() }

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

    private fun navigateBoardGamesApp(){
        var intent = Intent(this, boardGamesActivity::class.java)
        startActivity(intent)
    }
}
