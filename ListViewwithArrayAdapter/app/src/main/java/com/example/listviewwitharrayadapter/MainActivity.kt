package com.example.listviewwitharrayadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val countries = arrayOf(
        "Sri Lanka", "India", "USA", "Canada", "Australia", "Germany",
        "France", "Italy", "Spain", "Japan", "China"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listViewCountries)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCountry = countries[position]
            Toast.makeText(this, "You Selected: $selectedCountry", Toast.LENGTH_SHORT).show()
            }
        }

}