package com.example.agrilink

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class OTPregisterActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var spinnerLanguage: Spinner
    private lateinit var tvOtp: EditText
    private lateinit var btnVerifyOtp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpregister)

        btnBack = findViewById(R.id.btn_back)
        spinnerLanguage = findViewById(R.id.spinner_language)
        tvOtp = findViewById(R.id.tv_otp)
        btnVerifyOtp = findViewById(R.id.btn_verify_otp)

        // Disable the verify button initially
        btnVerifyOtp.isEnabled = false
        btnVerifyOtp.alpha = 0.5f

        // TextWatcher to monitor OTP input
        tvOtp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val isValidOtp = s?.trim()?.length == 8
                btnVerifyOtp.isEnabled = isValidOtp
                btnVerifyOtp.alpha = if (isValidOtp) 1.0f else 0.5f
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // Handle Verify OTP button click
        btnVerifyOtp.setOnClickListener {
            val enteredOtp = tvOtp.text.toString().trim()
            verifyOtp(enteredOtp)
        }

        // Handle back button click
        btnBack.setOnClickListener {
            val intent = Intent(this, RegisterPhoneNumberActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Spinner setup (uncomment if you have a languages array in resources)
        /*
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.languages,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLanguage.adapter = adapter
        */
    }

    private fun verifyOtp(otp: String) {
        if (otp.isEmpty()) {
            Toast.makeText(this, "Please enter the OTP", Toast.LENGTH_SHORT).show()
            return
            //if (otp == CORRECT_OTP) {
            // Toast.makeText(this, "OTP Verified Successfully!", Toast.LENGTH_SHORT).show()

            // Navigate to next activity
            // val intent = Intent(this, NextActivity::class.java)
            // startActivity(intent)
            // finish()
        } else {
            Toast.makeText(this, "Incorrect OTP. Please try again.", Toast.LENGTH_LONG).show()
            tvOtp.error = "Invalid OTP"
            tvOtp.requestFocus()
        }
    }
}
