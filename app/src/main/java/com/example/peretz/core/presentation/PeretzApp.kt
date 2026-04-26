package com.example.peretz.core.presentation

import android.app.Application
import com.example.peretz.core.domain.di.allModules
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class PeretzApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
        initNavigation()
    }

    private fun initDi() {
        GlobalContext.startKoin {
            androidContext(applicationContext)
            modules(allModules)
        }
    }

    private fun initNavigation() {
        NavigationControllerHolder.createNavigator(AppRegistryNavigationControllerFactory())
    }

}