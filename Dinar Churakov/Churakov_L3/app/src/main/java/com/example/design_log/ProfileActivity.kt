package com.example.design_log

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.design_log.databinding.ActivityProfileBinding
import com.example.design_log.fragments.ProfileFragment
import com.example.design_log.fragments.TasksFragment

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    supportBottomNavigation(TasksFragment())
                }
                R.id.menuProfile -> {
                    supportBottomNavigation(ProfileFragment())
                }
            }
            true
        }
    }
    private fun supportBottomNavigation(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
