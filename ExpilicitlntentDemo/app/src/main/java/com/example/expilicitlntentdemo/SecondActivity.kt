package com.example.expilicitlntentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val button = findViewById<Button>(R.id.buttonThanks)

        val textview = findViewById<TextView>(R.id.textviewResult)
        val name = intent.getStringExtra("user_name")
        textview.text = "Welcome, $name!"

        button.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}