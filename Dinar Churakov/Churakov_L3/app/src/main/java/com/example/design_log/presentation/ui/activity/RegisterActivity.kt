package com.example.design_log.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.common.validation.Validator
import com.example.design_log.data.https.ApiService
import com.example.design_log.data.https.model.Token
import com.example.design_log.data.https.model.UserCreate
import com.example.design_log.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            verificationRegister(binding)
        }

        binding.signInTextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun verificationRegister(binding: ActivityRegisterBinding) {
        val emailInputLayout = binding.inputLayoutEmail
        val passwordInputLayout = binding.inputLayoutPassword
        val usernameInputLayout = binding.inputLayoutName
        val confirmPasswordInputLayout = binding.inputLayoutConfirmPassword
        val validate = Validator(this)
        val preferenceManager = PreferenceManager(this)

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
            ApiService.retrofit.userCreate(
                UserCreate(
                    binding.editTextName.text.toString(),
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
            ).enqueue(
                object : Callback<Token> {
                    override fun onResponse(call: Call<Token>, response: Response<Token>) {

                        if (response.isSuccessful) {
                            val token = response.body()?.token
                            preferenceManager.writeLoginPreference(token.toString())
                            val intent = Intent(this@RegisterActivity, ProfileActivity::class.java)
                            intent.putExtra("Name", binding.editTextName.text.toString())
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this@RegisterActivity,
                                "Некорректные данные входа",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}
