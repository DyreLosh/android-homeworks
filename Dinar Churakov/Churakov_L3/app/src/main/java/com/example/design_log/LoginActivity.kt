package com.example.design_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.design_log.databinding.ActivityLoginBinding
import com.example.design_log.validation.Validation

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.emailLoginEditText
        val password = binding.passwordLoginEditText
        val validate = Validation()

        binding.signUpTextButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.signInButton.setOnClickListener {

            when (validate.validateLogin(email, password)) {
                1 -> email.error = getString(R.string.error_email_more8)
                2 -> email.error = getString(R.string.error_email_true)
                3 -> password.error = getString(R.string.error_email_more8)
                else -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}

