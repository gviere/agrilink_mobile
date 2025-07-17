package com.example.agrilink

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterPhoneNumberActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var spinnerLanguage: Spinner
    private lateinit var tvHeading: TextView
    private lateinit var etPhone: EditText
    private lateinit var btnSendOtp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerphonenumber)

        // View bindings
        btnBack = findViewById(R.id.btn_back)
        spinnerLanguage = findViewById(R.id.spinner_language)
        tvHeading = findViewById(R.id.tv_heading)
        etPhone = findViewById(R.id.et_phone)
        btnSendOtp = findViewById(R.id.btn_send_otp)

        // Spinner setup (assuming you have @array/languages in strings.xml)
        ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLanguage.adapter = adapter
        }

        // Back button functionality
        btnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Enable or disable Send OTP button based on phone number input
        etPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnSendOtp.isEnabled = s.toString().trim().length >= 7
            }
        })

        // Send OTP functionality
        btnSendOtp.setOnClickListener {
            val phone = etPhone.text.toString().trim()

            if (phone.length < 10) {
                etPhone.error = "Enter a valid phone number"
                etPhone.requestFocus()
                return@setOnClickListener
            }

            // OPTIONAL: Save selected language
            val selectedLanguage = spinnerLanguage.selectedItem.toString()

            // Proceed to OTP screen
            val intent = Intent(this, OTPregisterActivity::class.java)
            intent.putExtra("phone", phone)
            intent.putExtra("language", selectedLanguage)
            startActivity(intent)
        }
    }
}
