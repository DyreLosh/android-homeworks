package com.example.design_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.design_log.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.emailEditText
        val password = binding.passwordEditText
        val validate = Validate()

        binding.registerButton.setOnClickListener {
            when(validate.validateLogin(email,password)){
                1 -> email.error = getString(R.string.error_email_more8)
                2 -> email.error = getString(R.string.error_email_true)
                3 -> password.error = getString(R.string.error_email_more8)
                else -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        binding.signInTextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}



