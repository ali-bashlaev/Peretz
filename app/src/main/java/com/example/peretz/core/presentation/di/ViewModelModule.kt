package com.example.peretz.core.presentation.di

import com.example.peretz.core.presentation.viewmodels.AuthorizationViewModel
import com.example.peretz.core.presentation.viewmodels.HomeViewModel
import com.example.peretz.core.presentation.viewmodels.OtpViewModel
import com.example.peretz.core.presentation.viewmodels.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { HomeViewModel() }
    viewModel { AuthorizationViewModel() }
    viewModel { OtpViewModel() }
}
