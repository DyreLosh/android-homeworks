package com.example.l3

import android.content.Context

class Validator(private val context: Context) {
    fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> context.getString(R.string.error_emptiness)
            !(email.contains("@")) -> context.getString(R.string.error_email_writing)
            email.length <= 6 -> context.getString(R.string.error_email_length)
            else -> null
        }
    }
    fun validatePassword(password: String): String? {
        return when {
            password.isBlank() -> context.getString(R.string.error_emptiness)
            password.length <= 7 -> context.getString(R.string.error_password)
            else -> null
        }
    }
    fun passwordConfirmation(password: String, confirmedPassword: String): String? {
        return when {
            password.isBlank() -> context.getString(R.string.error_emptiness)
            confirmedPassword.isBlank() -> context.getString(R.string.error_emptiness)
            password != confirmedPassword -> context.getString(R.string.error_coincidence_password)
            else -> null
        }
    }
    fun validateName(name: String): String? {
        return when {
            name.isBlank() -> context.getString(R.string.error_emptiness)
            name.length <= 4 -> context.getString(R.string.error_name)
            else -> null
        }
    }
}
