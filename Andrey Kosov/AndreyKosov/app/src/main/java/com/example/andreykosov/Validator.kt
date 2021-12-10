package com.example.andreykosov

import android.content.Context

class Validator(private val context: Context) {
    fun validateEmail(emailValue: String): String? {
        return when {
            emailValue.isBlank() ->
                context.getString(R.string.error_empty)
            emailValue.length <= 6 ->
                context.getString(R.string.error_email_length)
            !(emailValue.contains("@")) ->
                context.getString(R.string.error_email_sign)
            else -> null
        }
    }
    fun validatePassword(passwordValue: String): String? {
        return when {
            passwordValue.isBlank() ->
                context.getString(R.string.error_empty)
            passwordValue.length <= 7 ->
                context.getString(R.string.error_password_length)
            else -> null
        }
    }
    fun validateEqualPassword(passwordValue: String, passwordConfirmValue: String): String? {
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
    fun validateName(nameValue: String): String? {
        return when {
            nameValue.isBlank() ->
                context.getString(R.string.error_empty)
            nameValue.length <= 4 ->
                context.getString(R.string.error_name_length)
            else -> null
        }
    }
}
