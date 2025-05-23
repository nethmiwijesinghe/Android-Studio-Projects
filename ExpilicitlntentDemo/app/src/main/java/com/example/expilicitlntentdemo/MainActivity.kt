package com.example.expilicitlntentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.buttonSend)

        button.setOnClickListener{
            val name = editText.text.toString()
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("user_name",name)
            startActivity(intent)
        }
    }
}