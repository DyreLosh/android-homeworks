package com.example.design_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.design_log.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val email = binding.emailLoginEditText
        val password = binding.passwordLoginEditText
        setContentView(binding.root)

        binding.signUpTextButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.signInButton.setOnClickListener {
            if (!(email.length() >= 6)) {
                email.error = getString(R.string.email_error8)
            } else if (!(email.text.toString().contains(getString(R.string.dog)))) {
                email.error = getString(R.string.email_error_dog)
            } else if (!(password.length() >= 7)) {
                password.error = getString(R.string.email_error8)
            } else {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, getString(R.string.coplete_login), Toast.LENGTH_LONG).show()
            }
        }
    }
}

