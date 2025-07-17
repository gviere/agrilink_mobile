package com.example.agrilink

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class setUpProfileActivity : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var languageSpinner: Spinner
    private lateinit var registerButton: Button
    private lateinit var termsCheckbox: CheckBox
    private lateinit var loginText: TextView
    private lateinit var termsLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_profile)

        backArrow = findViewById(R.id.btn_back)
        languageSpinner = findViewById(R.id.spinner_language)
        registerButton = findViewById(R.id.registerButton)
        termsCheckbox = findViewById(R.id.termsLayout)
        loginText = findViewById(R.id.loginText)
        termsLink = findViewById(R.id.termsCheckbox)

        // Language Spinner setup
        val languages = arrayOf("English", "Filipino")
        languageSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languages)

        // Back navigation
        backArrow.setOnClickListener {
            finish()
        }

        // Terms and conditions link
        termsLink.setOnClickListener {
            Toast.makeText(this, "Show Terms & Conditions", Toast.LENGTH_SHORT).show()
        }

        // Register button logic
        registerButton.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.firstNameEditText).text.toString().trim()
            val lastName = findViewById<EditText>(R.id.lastNameEditText).text.toString().trim()
            val email = findViewById<EditText>(R.id.emailEditText).text.toString().trim()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()
            val confirmPassword =
                findViewById<EditText>(R.id.confirmPasswordEditText).text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()
            ) {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email address.", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters.", Toast.LENGTH_SHORT)
                    .show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
            }  else {
                // Proceed with registration
                Toast.makeText(this, "Registered successfully!", Toast.LENGTH_SHORT).show()
            }
        }
        // Login text click
        loginText.setOnClickListener {
            // Navigate to login screen
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}



