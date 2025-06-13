package com.example.sharedprof_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textViewGreating: TextView
    private lateinit var editTextUserName: EditText
    private lateinit var btnSave: Button

    private val PREFS_NAME = "MyPrefs"
    private val KEY_USER_NAME = "user_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewGreating = findViewById(R.id.textViewGraeting)
        editTextUserName = findViewById(R.id.editTextUserName)
        btnSave = findViewById(R.id.btnSave)

        // Load saved user name
        val sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val savedUserName = sharedPreferences.getString(KEY_USER_NAME, "")

        if (savedUserName !=null) {
            textViewGreating.text = "Welcome back!, $savedUserName!"

        }

        btnSave.setOnClickListener {
            val userName = editTextUserName.text.toString().trim()

            if (userName.isNotEmpty()) {
                val editor= sharedPreferences.edit()
                editor.putString(KEY_USER_NAME, userName)
                editor.apply()

                textViewGreating.text = "Welcome, $userName!"
                editTextUserName.text.clear()
            }
        }
    }
}