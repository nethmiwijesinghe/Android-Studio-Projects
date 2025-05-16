package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

         val username = findViewById<EditText>(R.id.editUsername)
         val password = findViewById<EditText>(R.id.editPassword)
         val loginBtn = findViewById<Button>(R.id.btnLogin)
         val ResetBtn = findViewById<Button>(R.id.btnReset)

        val existUsername = "Admin"
        val existPassword = "admin"


        loginBtn.setOnClickListener{
            val user = username.text.toString()
            val pass = password.text.toString()
            if (existUsername==user && existPassword==pass) {
                Toast.makeText(this, "Successful Login", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
            }
        }

        ResetBtn.setOnClickListener{
            username.text.clear()
            password.text.clear()
        }
    }
}