package com.example.peretz.core.presentation

import com.example.peretz.core.presentation.navigation.Screens
import com.jamal_aliev.navigationcontroller.core.NavigationControllerFactory

class AppRegistryNavigationControllerFactory : NavigationControllerFactory() {
    init {
        registerFragment(
            Screens.Home::class.java,
            HomeFragment::class.java
        )
        registerFragment(
            Screens.Sale::class.java,
            SaleFragment::class.java
        )
    }
}