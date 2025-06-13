package com.example.internalserver

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
    lateinit var btnDelete: Button

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
        btnDelete = findViewById(R.id.btnDelete)

        // Set up button click listeners
        btnInsert.setOnClickListener {
            val id = eId.text.toString().toIntOrNull()
            val name = eName.text.toString()
            val email = eEmail.text.toString()

            if (id != null && name.isNotEmpty() && email.isNotEmpty()) {
                val success = dbHelper.insertEmployee(id, name, email)
                if (success) {
                    Toast.makeText(this, "Inserted successfully", Toast.LENGTH_SHORT).show()
                    eId.text.clear()
                    eName.text.clear()
                    eEmail.text.clear()
                } else {
                    Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields ", Toast.LENGTH_SHORT).show()
            }
        }
        btnView.setOnClickListener {
            val result = dbHelper.getAllEmployees()
            tvResult.text = result
        }

        btnDelete.setOnClickListener {
            val id = eId.text.toString().toIntOrNull()
            if (id != null) {
                val success = dbHelper.deleteEmployee(id)
                if (success) {
                    Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show()
                    eId.text.clear()
                } else {
                    Toast.makeText(this, "Deletion failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid ID", Toast.LENGTH_SHORT).show()
            }
        }
    }
}