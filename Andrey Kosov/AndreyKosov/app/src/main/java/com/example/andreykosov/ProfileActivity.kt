package com.example.andreykosov

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andreykosov.databinding.ActivityProfileBinding
import com.example.andreykosov.fragments.ProfileFragment
import com.example.andreykosov.fragments.TasksFragment

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationViewProfile.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuTasks -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerViewProfile, TasksFragment())
                        .commit()
                }
                R.id.menuProfile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerViewProfile, ProfileFragment())
                        .commit()
                }
            }
            true
        }
    }
}
