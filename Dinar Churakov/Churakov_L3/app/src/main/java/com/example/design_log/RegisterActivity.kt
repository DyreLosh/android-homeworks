package com.example.design_log

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.databinding.ActivityRegisterBinding
import com.example.design_log.validation.Validator

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailInputLayout = binding.inputLayoutEmail
        val passwordInputLayout = binding.inputLayoutPassword
        val usernameInputLayout = binding.inputLayoutName
        val confirmPasswordInputLayout = binding.inputLayoutConfirmPassword
        val validate = Validator(this)

        binding.registerButton.setOnClickListener {
            usernameInputLayout.error = validate.validateName(binding.editTextName)
            emailInputLayout.error = validate.validateEmail(binding.editTextEmail)
            passwordInputLayout.error = validate.validatePassword(binding.editTextPassword)
            confirmPasswordInputLayout.error = validate.confirmPassword(
                binding.editTextPassword,
                binding.editTextConfirmPassword
            )

            if (usernameInputLayout.error == null &&
                emailInputLayout.error == null &&
                passwordInputLayout.error == null &&
                confirmPasswordInputLayout.error == null
            ) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", binding.editTextName.text.toString())
                startActivity(intent)
                finish()
            }
        }

        binding.signInTextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
