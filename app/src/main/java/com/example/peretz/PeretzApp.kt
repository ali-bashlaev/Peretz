package com.example.peretz

import android.app.Application
import com.example.peretz.core.domain.di.allModules
import com.example.peretz.core.presentation.navigation.AppRegistryNavigationControllerFactory
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PeretzApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
        initNavigation()
    }

    private fun initDi() {
        startKoin {
            androidContext(applicationContext)
            modules(allModules)
        }
    }

    private fun initNavigation() {
        NavigationControllerHolder.createNavigator(AppRegistryNavigationControllerFactory())
    }

}
