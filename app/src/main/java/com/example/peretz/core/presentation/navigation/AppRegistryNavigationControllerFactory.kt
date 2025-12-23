package com.example.peretz.core.presentation.navigation

import com.example.peretz.InputNumberFragment
import com.example.peretz.OtpFragment
import com.example.peretz.SplashFragment
import com.jamal_aliev.navigationcontroller.core.NavigationControllerFactory


class AppRegistryNavigationControllerFactory : NavigationControllerFactory() {
    init {
        registerFragment(
            Screens.Splash::class.java,
            SplashFragment::class.java
        )
        registerFragment(
            Screens.InputPhone::class.java,
            InputNumberFragment::class.java
        )
        registerFragment(
            Screens.Otp::class.java,
            OtpFragment::class.java
        )
    }
}