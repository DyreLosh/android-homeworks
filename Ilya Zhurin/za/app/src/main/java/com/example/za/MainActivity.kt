package com.example.za

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.za.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.MainSignButton.setOnClickListener {
            val password = binding.editTextPasswordLogin.text.toString()
            val email = binding.editTextEmailLogin.text.toString()
            val valid = Validator(this)
            binding.inputLayoutEmailLogin.error = valid.checkEmail(email)
            binding.inputLayoutPasswordLogin.error = valid.checkPassword(password)
            if (binding.inputLayoutEmailLogin.error == null &&
                binding.inputLayoutPasswordLogin.error == null
            ) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", email)
                startActivity(intent)
            }
        }
        binding.mainTextSingnUp.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
