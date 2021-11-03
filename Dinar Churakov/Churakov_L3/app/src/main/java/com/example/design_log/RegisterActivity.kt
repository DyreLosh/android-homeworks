package com.example.design_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.design_log.databinding.ActivityRegisterBinding
import com.example.design_log.validation.Validation

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.emailEditText
        val password = binding.passwordEditText
        val username = binding.fullNameEditText
        val confirmPassword = binding.confirmPasswordEditText
        val validate = Validation()

        binding.registerButton.setOnClickListener {
            when (validate.validateRegister(username, email, password, confirmPassword)) {
                0 -> username.error = getString(R.string.error_username_more4)
                1 -> email.error = getString(R.string.error_email_more8)
                2 -> email.error = getString(R.string.error_email_true)
                3 -> password.error = getString(R.string.error_email_more8)
                4 -> confirmPassword.error = getString(R.string.error_confirm)
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



