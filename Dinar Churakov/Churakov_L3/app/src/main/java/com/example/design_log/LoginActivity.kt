package com.example.design_log

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.databinding.ActivityLoginBinding
import com.example.design_log.validation.Validator

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.editTextEmailLogin
        val password = binding.editTextPasswordLogin
        val emailInputLayout = binding.inputLayoutEmailLogin
        val passwordInputLayout = binding.inputLayoutPasswordLogin
        val validate = Validator(this)

        binding.signUpTextButton.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.signInButton.setOnClickListener {

            emailInputLayout.error = validate.validateEmail(email)
            passwordInputLayout.error = validate.validatePassword(password)

            if (emailInputLayout.error == null &&
                passwordInputLayout.error == null
            ) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", email.text.toString())
                startActivity(intent)
            }
        }
    }
}
