package com.example.andreykosov

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andreykosov.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.materialButtonSignIn.setOnClickListener {
            val validation = Validator(this)
            val emailValue = binding.textInputEditTextSignInEmail.text.toString()
            val passwordValue = binding.textInputEditTextSignInPassword.text.toString()
            binding.textInputLayoutSignInEmail.error = validation.validateEmail(emailValue)
            binding.textInputLayoutSignInPassword.error = validation.validatePassword(passwordValue)
            if (binding.textInputLayoutSignInEmail.error.isNullOrBlank() &&
                binding.textInputLayoutSignInPassword.error.isNullOrBlank()
            ) {
                val intentProfile = Intent(this, ProfileActivity::class.java)
                intentProfile.putExtra("Name", emailValue)
                startActivity(intentProfile)
            }
        }
        binding.textViewSignInBottomClickable.setOnClickListener {
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }
    }
}
