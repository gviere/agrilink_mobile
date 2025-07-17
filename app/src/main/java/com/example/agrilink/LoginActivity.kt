package com.example.agrilink

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: Button
    private lateinit var cbRememberMe: CheckBox
    private lateinit var tvForgotPassword: TextView
    private lateinit var cvGoogleSignin: CardView
    private lateinit var tvRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        cbRememberMe = findViewById(R.id.cb_remember_me)
        tvForgotPassword = findViewById(R.id.tv_forgot_password)
        cvGoogleSignin = findViewById(R.id.googleButton)
        tvRegister = findViewById(R.id.tv_register)
    }

    private fun setupClickListeners() {
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            handleLogin(email, password)
        }

        tvForgotPassword.setOnClickListener {
            handleForgotPassword()
        }

        cvGoogleSignin.setOnClickListener {
            handleGoogleSignIn()
        }

        tvRegister.setOnClickListener {
            handleRegister()
        }
    }

    private fun handleLogin(email: String, password: String) {
        // TODO: Implement login logic
        println("Login attempt with email: $email")
    }

    private fun handleForgotPassword() {
        // TODO: Implement forgot password logic
        println("Forgot password clicked")
    }

    private fun handleGoogleSignIn() {
        // TODO: Implement Google sign-in logic
        println("Google sign-in attempt")
    }

    private fun handleRegister() {
        // Create an Intent to start RegisterActivity
        val intent = Intent(this, RegisterPhoneNumberActivity::class.java)
        startActivity(intent)
    }
}
