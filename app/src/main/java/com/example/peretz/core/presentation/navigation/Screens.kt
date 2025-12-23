package com.example.peretz.core.presentation.navigation

import me.aartikov.alligator.Screen
import java.io.Serializable

object Screens {

    data object Splash : Screen

    data object InputPhone : Screen

    data class Otp(val phone: String) : Screen, Serializable
}