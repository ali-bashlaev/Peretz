package com.example.peretz.core.presentation.navigation

import com.example.peretz.HomeFragment
import com.jamal_aliev.navigationcontroller.core.NavigationControllerFactory

class AppRegistryNavigationControllerFactory : NavigationControllerFactory() {
    init {
        registerFragment(
            Screens.Home::class.java,
            HomeFragment::class.java
        )
    }
}