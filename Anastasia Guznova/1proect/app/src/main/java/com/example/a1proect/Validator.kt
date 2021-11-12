package com.example.a1proect

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
    fun validateIdenticalPassword(pass1: String, pass2: String): String? {
        return when {
            pass1.isBlank() -> context.getString(R.string.error_emptiness)
            pass2.isBlank() -> context.getString(R.string.error_emptiness)
            pass1 != pass2 -> context.getString(R.string.error_coincidence_password)
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
