package com.example.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val validator = Validator(this)

        binding.buttonLoginSingIn.setOnClickListener {
            val userPassword = binding.editTextLoginPassword.text.toString()
            val userEmail = binding.editTextLoginEmail.text.toString()
            binding.inputLayoutLoginEmail.error = validator.checkEmail(userEmail)
            binding.inputLayoutLoginPassword.error = validator.checkPassword(userPassword)
            if (binding.inputLayoutLoginEmail.error == null &&
                binding.inputLayoutLoginPassword.error == null
            ) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", userEmail)
                startActivity(intent)
            }
        }
        binding.textViewLoginSingIn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
