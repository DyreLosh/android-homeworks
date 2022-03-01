package com.example.design_log.presentation.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferenceManager = PreferenceManager(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if (preferenceManager.readLoginPreference().isBlank()) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            finish()
        }, 1500)
    }
}
