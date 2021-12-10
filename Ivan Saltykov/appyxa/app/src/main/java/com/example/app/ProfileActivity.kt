package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { menuitem ->
            when (menuitem.itemId) {
                R.id.menuFragmentprofile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentcontainerprofile, ProfileFragment())
                        .commit()
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.menuFragmenttasks -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentcontainerprofile, TasksFragment())
                        .commit()
                    Toast.makeText(this, "Tasks", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}
