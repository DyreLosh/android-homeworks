package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonMain.setOnClickListener {
            val valid = Validator(this)
            val email = binding.editTextMainEmail.text.toString()
            val password = binding.editTextMainPassword.text.toString()
            binding.inputLayoutMainEmail.error = valid.checkEmail(email)
            binding.inputLayoutMainPassword.error = valid.checkPassword(password)
            if (binding.inputLayoutMainEmail.error.isNullOrBlank() &&
                binding.inputLayoutMainPassword.error.isNullOrBlank()
            ) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email", email)
                startActivity(intent)
            }
        }
        binding.textMainLink.setOnClickListener {
            val intentReg = Intent(this, RegistrationActivity::class.java)
            startActivity(intentReg)
        }
    }
}
