package com.example.za

import android.content.Context

class Validator(private val context: Context) {

    fun checkEmail(email: String): String? {
        return when {
            email.isBlank() -> context.getString(R.string.error_empty)
            email.length <= 6 -> context.getString(R.string.error_email_length)
            !(email.contains("@")) -> context.getString(R.string.error_email_sign)
            else -> null
        }
    }
    fun checkPassword(passwordValue: String): String? {
        return when {
            passwordValue.isBlank() ->
                context.getString(R.string.error_empty)
            passwordValue.length <= 7 ->
                context.getString(R.string.error_password_length)
            else -> null
        }
    }
    fun confirmPassword(passwordValue: String, passwordConfirmValue: String): String? {
        return when {
            passwordValue.isBlank() ->
                context.getString(R.string.error_empty)
            passwordConfirmValue.isBlank() ->
                context.getString(R.string.error_empty)
            passwordValue != passwordConfirmValue ->
                context.getString(R.string.error_password_different)
            else -> null
        }
    }
    fun checkName(nameValue: String): String? {
        return when {
            nameValue.isBlank() ->
                context.getString(R.string.error_empty)
            nameValue.length <= 4 ->
                context.getString(R.string.error_name_length)
            else -> null
        }
    }
}
