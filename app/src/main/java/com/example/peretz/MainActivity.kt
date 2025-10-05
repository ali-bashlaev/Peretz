package com.example.peretz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jamal_aliev.navigationcontroller.controllers.LineNavigationControllerFragmentScreen
import com.jamal_aliev.navigationcontroller.core.NavigationControllerFragment

class MainActivity : AppCompatActivity() {

    private var isFirstStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isFirstStart = savedInstanceState == null
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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
    }
}