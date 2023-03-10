package com.example.app

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)

        setupNav()
        setupToolbar()
    }

    private fun setupNav() {
        val bottomNavigationView: BottomNavigationView = binding.bottomNavView

        bottomNavigationView.setupWithNavController(navController)
    }

    private fun setupToolbar() {
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home
            )
        )

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)

        binding.searchBar.setOnClickListener {
            binding.searchView.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}