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
        binding.homeBottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuFragmentProfile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.homeFragmentContainerView, ProfileFragment())
                        .commit()
                }
                R.id.menuFragmentTaskList -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.homeFragmentContainerView, HomeTasksListFragment())
                        .commit()
                }
            }
            true
        }
    }
}
