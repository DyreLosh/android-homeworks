package com.example.design_log

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.design_log.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarTask)
        addEmailNameToMenu(binding)
        onNavigateOptionsMenu(binding)
    }

    private fun onNavigateOptionsMenu(binding: ActivityProfileBinding) {

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(binding.profileDrawerLayout)
        val appBarConfiguration = builder.build()
        binding.toolbarTask.setupWithNavController(navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.profileMenu, navController)
    }

    private fun addEmailNameToMenu(binding: ActivityProfileBinding) {

        val headerEmailText: TextView = binding.profileMenu.getHeaderView(0)
            .findViewById(R.id.headerEmailText)
        val name = intent.getStringExtra("Name")
        headerEmailText.text = getString(R.string.header_email_text, name)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenu -> {
                finish()
            }
        }
        return true
    }
}
