package com.example.simplegallery

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        lateinit var imageView: ImageView
        lateinit var buttonruwanweliseya: Button
        lateinit var buttonsigiriya: Button
        lateinit var buttonpinnawala: Button


        imageView = findViewById(R.id.imageView)
        buttonruwanweliseya = findViewById(R.id.buttonruwanweliseya)
        buttonsigiriya = findViewById(R.id.buttonsigiriya)
        buttonpinnawala = findViewById(R.id.buttonpinnawala)

        buttonruwanweliseya.setOnClickListener{
            imageView.setImageResource(R.drawable.ruwanwalisaya)
        }
        buttonsigiriya.setOnClickListener{
            imageView.setImageResource(R.drawable.sigiriya)
        }
        buttonpinnawala.setOnClickListener{
            imageView.setImageResource(R.drawable.zoo)
        }
    }
}
