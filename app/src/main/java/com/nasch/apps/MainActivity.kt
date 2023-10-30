package com.nasch.apps

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etSpace)
        var title = findViewById<TextView>(R.id.title)


        btnSend.setOnClickListener{
            var name=userText.text.toString()

            if (name.isNotEmpty()){
                var textIntent = Intent(this, SecondActivity::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
                title.setText("Received Message")
            }

        }
    }
}







