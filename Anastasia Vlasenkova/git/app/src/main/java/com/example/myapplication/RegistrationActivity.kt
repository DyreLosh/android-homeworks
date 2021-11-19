package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate((layoutInflater))
        setContentView(binding.root)
        binding.buttonRegistration.setOnClickListener {
            val valid = Validator(this)
            val email = binding.editTextRegistrationEmail.text.toString()
            val password = binding.editTextRegistrationPassword.text.toString()
            val passwordRepeat = binding.editTextRegistrationConfirm.text.toString()
            val name = binding.editTextRegistrationName.text.toString()
            binding.inputLayoutRegistrationConfirm.error =
                valid.checkPasswordEquality(password, passwordRepeat)
            binding.inputLayoutRegistrationEmail.error = valid.checkEmail(email)
            binding.inputLayoutRegistrationName.error = valid.checkName(name)
            binding.inputLayoutRegistrationPassword.error = valid.checkPassword(password)
            if (binding.inputLayoutRegistrationConfirm.error.isNullOrEmpty() &&
                binding.inputLayoutRegistrationEmail.error.isNullOrEmpty() &&
                binding.inputLayoutRegistrationName.error.isNullOrEmpty() &&
                binding.inputLayoutRegistrationPassword.error.isNullOrEmpty()
            ) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email", email)
                startActivity(intent)
            }
        }
        binding.textRegistrationLink.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}
