package com.example.manager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainNavBottom = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHost.navController

        mainNavBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_fragment_button -> {
                    navController.navigate(R.id.HomeFragment)
                    true
                }
                R.id.settings_fragment_button -> {
                    navController.navigate(R.id.SettingsFragment)
                    true
                }
                R.id.stats_fragment_button -> {
                    navController.navigate(R.id.StatsFragment)
                    true
                }

                else -> {
                    navController.navigate(R.id.HomeFragment)
                    true
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}