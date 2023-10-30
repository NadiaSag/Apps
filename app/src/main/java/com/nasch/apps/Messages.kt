package com.nasch.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Messages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var etSpace = findViewById<EditText>(R.id.etSpace)

        btnSend.setOnClickListener{
            var name=etSpace.text.toString()
            if (name.isNotEmpty()){
                var textIntent = Intent(this, SecondActivity::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
            }

        }
    }
}