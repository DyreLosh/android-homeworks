package com.example.design_log.validation

import android.content.Context
import android.widget.EditText
import com.example.design_log.R

class Validator(private val context: Context) {

    fun validateName(name: EditText): String? =
        if (name.length() <= 4) context.getString(R.string.error_username_more4)
        else null

    fun validateEmail(email: EditText): String? =
        when {
            email.length() <= 8 -> context.getString(R.string.error_email_more8)
            !(email.text.toString().contains("@")) -> context.getString(R.string.error_email_true)
            else -> null
        }

    fun validatePassword(password: EditText): String? =
        if (password.length() <= 8) context.getString(R.string.error_email_more8)
        else null

    fun confirmPassword(password: EditText, confirmPassword: EditText): String? =
        if (password.text.toString() != confirmPassword.text.toString())
            context.getString(R.string.error_confirm)
        else null
}
