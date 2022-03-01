package com.example.design_log.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.common.validation.Validator
import com.example.design_log.data.https.ApiService
import com.example.design_log.data.https.model.Token
import com.example.design_log.data.https.model.UserLogin
import com.example.design_log.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpTextButton.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.signInButton.setOnClickListener {
            verificationLogin(binding)
        }
    }

    private fun verificationLogin(binding: ActivityLoginBinding) {
        val email = binding.editTextEmailLogin
        val password = binding.editTextPasswordLogin
        val emailInputLayout = binding.inputLayoutEmailLogin
        val passwordInputLayout = binding.inputLayoutPasswordLogin
        val validate = Validator(this)
        val preferenceManager = PreferenceManager(this)
        emailInputLayout.error = validate.validateEmail(email)
        passwordInputLayout.error = validate.validatePassword(password)

        if (emailInputLayout.error == null &&
            passwordInputLayout.error == null
        ) {
            ApiService.retrofit.userLogin(
                UserLogin(
                    email.text.toString(),
                    password.text.toString()
                )
            ).enqueue(
                object : Callback<Token> {
                    override fun onResponse(call: Call<Token>, response: Response<Token>) {

                        when (response.code()) {
                            200 -> {
                                val token = response.body()?.token
                                preferenceManager.writeLoginPreference(token.toString())
                                val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                                intent.putExtra("Name", email.text.toString())
                                startActivity(intent)
                                finish()
                            }

                            400 -> Toast.makeText(
                                this@LoginActivity,
                                "Проблемы при входе в аккаунт",
                                Toast.LENGTH_SHORT
                            ).show()

                            401 -> Toast.makeText(
                                this@LoginActivity,
                                "Некорректные данные входа",
                                Toast.LENGTH_SHORT
                            ).show()

                            else -> Toast.makeText(
                                this@LoginActivity,
                                "Неизвестная ошибка",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}
