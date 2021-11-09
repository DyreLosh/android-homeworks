package com.example.design_log

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design_log.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.extras?.getString("name")
        binding.profActWelcomeText.text = name

        binding.imageButtonLogOut.setOnClickListener {
            finish()
        }
    }
}
