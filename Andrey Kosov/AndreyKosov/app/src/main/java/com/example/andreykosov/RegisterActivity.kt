package com.example.andreykosov

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andreykosov.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            textViewRegisterBottom.setOnClickListener {
                val intentSignIn = Intent(this@RegisterActivity, SignInActivity::class.java)
                startActivity(intentSignIn)
            }
            materialButtonRegister.setOnClickListener {
                val validation = Validator(this@RegisterActivity)
                val name = textInputEditTextRegisterName.text.toString()
                val email = textInputEditTextRegisterEmail.text.toString()
                val password = textInputEditTextRegisterPassword.text.toString()
                val passwordConfirm = textInputEditTextRegisterConfirmPassword.text.toString()
                textInputLayoutRegisterName.error =
                    validation.validateName(name)
                textInputLayoutRegisterEmail.error =
                    validation.validateEmail(email)
                textInputLayoutRegisterPassword.error =
                    validation.validatePassword(password)
                textInputLayoutRegisterConfirmPassword.error =
                    validation.validateEqualPassword(password, passwordConfirm)
                if (textInputLayoutRegisterEmail.error == null &&
                    textInputLayoutRegisterPassword.error == null &&
                    textInputLayoutRegisterConfirmPassword.error == null &&
                    textInputLayoutRegisterName.error == null

                ) {
                    val intentProfile = Intent(this@RegisterActivity, ProfileActivity::class.java)
                    intentProfile.putExtra("Name", textInputEditTextRegisterName.text.toString())
                    startActivity(intentProfile)
                }
            }
        }
    }
}
