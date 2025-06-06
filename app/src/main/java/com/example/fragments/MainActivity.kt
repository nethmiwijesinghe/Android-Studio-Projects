package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnA = findViewById<android.widget.Button>(R.id.btnLoadFragmentA)
        val btnB = findViewById<android.widget.Button>(R.id.btnLoadFragmentB)

        btnA.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentController, fragment_a())
                .commit()

            btnB.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentController, fragment_b())
                    .commit()
            }
            }
        }
}
