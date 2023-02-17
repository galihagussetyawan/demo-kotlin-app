package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()
    }

    private fun setupNav() {
        val bottomNavigationView: BottomNavigationView = binding.bottomNavView
        val navController: NavController = findNavController(R.id.nav_host_fragment)

        bottomNavigationView.setupWithNavController(navController)

//        appbar
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home
        ))

        val toolbar = binding.toolbar
        toolbar.setupWithNavController(navController, appBarConfiguration)

        setSupportActionBar(toolbar)
    }

}