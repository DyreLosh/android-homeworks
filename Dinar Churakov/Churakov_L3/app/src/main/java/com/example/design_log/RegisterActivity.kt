package com.example.design_log

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.databinding.ActivityRegisterBinding
import com.example.design_log.validation.Validation

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.editTextEmail
        val password = binding.editTextPassword
        val username = binding.editTextName
        val confirmPassword = binding.editTextConfirmPassword
        val validate = Validation(this)

        binding.registerButton.setOnClickListener {
            username.error = validate.validateName(username)
            email.error = validate.validateEmail(email)
            password.error = validate.validatePassword(password)
            confirmPassword.error = validate.confirmPassword(password, confirmPassword)

            if (validate.validateName(username) == null && validate.validateEmail(email) == null
                && validate.validatePassword(password) == null
                && validate.confirmPassword(password, confirmPassword) == null) {

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }

        binding.signInTextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}




