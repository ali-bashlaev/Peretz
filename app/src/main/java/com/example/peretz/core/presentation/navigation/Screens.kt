package com.example.peretz.core.presentation.navigation

import me.aartikov.alligator.Screen
import java.io.Serializable

object Screens {

    data object Splash : Screen, Serializable {
        private fun readResolve(): Any = Splash
    }

    data object InputPhone : Screen, Serializable {
        private fun readResolve(): Any = InputPhone
    }

    data class Otp(val phone: String) : Screen, Serializable

    data object Home : Screen, Serializable {
        private fun readResolve(): Any = Home
    }
}