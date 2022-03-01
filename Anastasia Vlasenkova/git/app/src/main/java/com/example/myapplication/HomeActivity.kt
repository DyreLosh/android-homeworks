package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationViewHome.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menuFragmentHomeProfile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, ProfileHomeFragment())
                        .commit()
                }
                R.id.menuFragmentHomeTasksList -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, TasksListHomeFragment())
                        .commit()
                }
            }
            true
        }
    }
}
