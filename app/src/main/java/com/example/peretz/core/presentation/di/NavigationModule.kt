package com.example.peretz.core.presentation.di

import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import me.aartikov.alligator.AndroidNavigator
import org.koin.dsl.module

val navigationModule = module {
    factory<AndroidNavigator> { NavigationControllerHolder.requireNavigator() }
}
