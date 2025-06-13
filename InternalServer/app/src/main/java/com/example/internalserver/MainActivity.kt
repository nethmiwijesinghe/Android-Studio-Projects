package com.example.internalserver

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: EmployeeDbHelper
    lateinit var eId :EditText
    lateinit var eName :EditText
    lateinit var eEmail :EditText
    lateinit var tvResult: TextView
    lateinit var btnInsert: Button
    lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the database helper
        dbHelper = EmployeeDbHelper(this)

        // Initialize UI components
        eId = findViewById(R.id.etEmpId)
        eName = findViewById(R.id.etEmpName)
        eEmail = findViewById(R.id.EmpEmail)
        tvResult = findViewById(R.id.tvResult)
        btnInsert = findViewById(R.id.btnInsert)
        btnView = findViewById(R.id.btnView)

        // Set up button click listeners
        btnInsert.setOnClickListener {
            val id = eId.text.toString().toIntOrNull()
            val name = eName.text.toString()
            val email = eEmail.text.toString()
            if (id != null && name.isNotEmpty() && email.isNotEmpty()) {
                val success = dbHelper.insertEmployee(id, name, email)
                tvResult.text = if (success) "Employee inserted successfully." else "Error inserting employee."
            } else {
                tvResult.text = "Please enter valid data."
            }
        }

        btnView.setOnClickListener {
            tvResult.text = dbHelper.getAllEmployees()
        }
    }
}