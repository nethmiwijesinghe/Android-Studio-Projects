package com.example.example1relative


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.editName)
        val email = findViewById<EditText>(R.id.editEmail)
        val phone = findViewById<EditText>(R.id.editPhone)
        val dob = findViewById<EditText>(R.id.editDob)
        val genderGroup = findViewById<RadioGroup>(R.id.editgenderGroup)
        val submitBtn = findViewById<Button>(R.id.btnSubmit)

        submitBtn.setOnClickListener{
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId)?.text ?: "Not Selected"

            val messages = """
                Name:${name.text}
                Email:${email.text}
                Phone:${phone.text}
                DOB:${dob.text}
                """.trimIndent()
            Toast.makeText(this,messages,Toast.LENGTH_LONG).show()


        }
    }
}