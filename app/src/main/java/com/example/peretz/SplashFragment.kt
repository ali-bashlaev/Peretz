package com.example.peretz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.peretz.core.presentation.navigation.Screens
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import me.aartikov.alligator.Navigator



class SplashFragment : Fragment(R.layout.fragment_splash_screen) {

    private val navigator: Navigator = NavigationControllerHolder.requireNavigator()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.postDelayed({
            navigator.goForward(Screens.InputPhone)
        }, 5000L)
    }
}