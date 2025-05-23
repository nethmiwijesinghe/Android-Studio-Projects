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

        // Get references to the EditText and Button from the layout
        val editText = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.buttonSend)

        // Set a click listener on the button
        button.setOnClickListener{
            // Get the text entered by the user
            val name = editText.text.toString()
            // Create an explicit intent to start SecondActivity
            val intent = Intent(this,SecondActivity::class.java)
            // Pass the user's name to SecondActivity using intent extras
            intent.putExtra("user_name",name)
            // Start SecondActivity
            startActivity(intent)
        }
    }
}
