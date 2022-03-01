package com.example.design_log.common.preference

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

class PreferenceManager(private val context: Context) {

    companion object {
        private const val PREFERENCE_TOKEN = "token"
        private const val KEY_TOKEN = "TOKEN"
    }

    fun writeLoginPreference(token: String) {

        val preference = context.getSharedPreferences(PREFERENCE_TOKEN, Context.MODE_PRIVATE)
        preference.edit().putString(KEY_TOKEN, token).apply()
    }

    fun readLoginPreference(): String {

        val preference = context.getSharedPreferences(PREFERENCE_TOKEN, Context.MODE_PRIVATE)
        return preference.getString(KEY_TOKEN, null) ?: ""
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteLoginPreference(): String {
        val preference = context.deleteSharedPreferences(PREFERENCE_TOKEN)
        return preference.toString()
    }
}
