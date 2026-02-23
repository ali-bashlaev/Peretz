package com.example.peretz.core.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.peretz.R
import com.example.peretz.core.presentation.navigation.Screens
import com.example.peretz.databinding.ActivityMainBinding
import com.jamal_aliev.navigationcontroller.controllers.LineNavigationControllerFragmentScreen
import com.jamal_aliev.navigationcontroller.core.NavigationControllerFragment
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import me.aartikov.alligator.Navigator

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var isFirstStart = true
    private val navigator: Navigator = NavigationControllerHolder.requireNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        isFirstStart = savedInstanceState == null
        enableEdgeToEdge()
        initInsets()

        if (isFirstStart) {
            initNavigation()
        }
    }

    private fun initInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.navigation_container)
        ) { v, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            return@setOnApplyWindowInsetsListener insets
        }
    }

    private fun initNavigation() {
        NavigationControllerFragment.Builder()
            .setRootScreen(LineNavigationControllerFragmentScreen())
            .show(supportFragmentManager, R.id.navigation_container)
        navigator.goForward(Screens.Home)
    }
}