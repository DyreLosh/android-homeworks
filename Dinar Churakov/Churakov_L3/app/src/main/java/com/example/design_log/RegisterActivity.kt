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
        val confirmPassword = binding.confirmPasswordEditText
        setContentView(binding.root)

        val email = binding.emailEditText
        val password = binding.passwordEditText
        val userName = binding.fullNameEditText

        binding.registerButton.setOnClickListener {

            if (!(userName.length() >= 4)) {
                userName.error = getString(R.string.userName_valid)
            } else if (!(email.length() >= 6)) {
                email.error = getString(R.string.email_error8)
            } else if (!(email.text.toString().contains(getString(R.string.dog)))) {
                email.error = getString(R.string.email_error_dog)
            } else if (!(password.length() >= 7)) {
                password.error = getString(R.string.email_error8)
            } else if (confirmPassword.text.toString() != password.text.toString()) {
                confirmPassword.error = getString(R.string.dont_confirm)
            } else {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, getString(R.string.reg_complete), Toast.LENGTH_LONG).show()
            }
        }

        binding.signInTextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}



