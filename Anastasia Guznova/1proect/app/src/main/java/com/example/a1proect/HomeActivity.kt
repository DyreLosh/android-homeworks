package com.example.a1proect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proect.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName = intent.extras?.getString("Name")
        binding.profTextWelcome.text = getString(R.string.home_greeting, userName)
        binding.iconExit.setOnClickListener {
            finish()
        }
    }
}
