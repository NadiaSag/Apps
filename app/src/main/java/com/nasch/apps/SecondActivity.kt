package com.nasch.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var title = findViewById<TextView>(R.id.title)

        // Recibe el mensaje de la actividad anterior
        val message = intent.getStringExtra("extra_name")

        // Encuentra la TextView en el diseño de la actividad
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)

        // Establece el mensaje en la TextView
        textViewMessage.text = message
        title.setText("Received Message")

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etSpace)
        btnSend.setOnClickListener{
            onBackPressed()

        }

    }
}
