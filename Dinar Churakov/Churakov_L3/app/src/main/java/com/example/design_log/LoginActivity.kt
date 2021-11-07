package com.example.design_log

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.databinding.ActivityLoginBinding
import com.example.design_log.validation.Validation

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.editTextEmailLogin
        val password = binding.editTextPasswordLogin
        val validate = Validation(this)

        binding.signUpTextButton.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.signInButton.setOnClickListener {

            email.error = validate.validateEmail(email)
            password.error = validate.validatePassword(password)

            if (validate.validateEmail(email) == null &&
                validate.validatePassword(password) == null)
                {

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
