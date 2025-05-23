package com.example.exerciseone

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkboxReading = findViewById<CheckBox>(R.id.checkBoxReading)
        val checkboxTravelling = findViewById<CheckBox>(R.id.checkBoxTravelling)
        val checkboxCooking = findViewById<CheckBox>(R.id.checkBoxCooking)
        val checkboxGaming = findViewById<CheckBox>(R.id.checkBoxGaming)
        val btnShowSelection = findViewById<Button>(R.id.btnShowSelection)
        val textResult = findViewById<TextView>(R.id.textResult)

        btnShowSelection.setOnClickListener{
            val selectedHobbies = StringBuilder("Selected hobbies:\n")

            if (checkboxReading.isChecked) selectedHobbies.append("- Reading\n")
            if (checkboxTravelling.isChecked) selectedHobbies.append("- Traveling\n")
            if (checkboxGaming.isChecked) selectedHobbies.append("- Gaming\n")
            if (checkboxCooking.isChecked) selectedHobbies.append("- Cooking\n")

            if (selectedHobbies.toString() == "Selected Hobbies: \n") {
                textResult.text = "No hobbies selected"
            } else {
                textResult.text = selectedHobbies.toString()
            }
        }
    }
}