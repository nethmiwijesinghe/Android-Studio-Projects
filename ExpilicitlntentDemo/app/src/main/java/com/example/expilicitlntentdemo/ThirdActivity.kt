package com.example.expilicitlntentdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val textview = findViewById<TextView>(R.id.textViewThankYou)
        textview.text = "Thank You!"
    }
}