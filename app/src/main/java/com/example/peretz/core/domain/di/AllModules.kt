package com.example.peretz.core.domain.di

import com.example.peretz.core.presentation.di.navigationModule
import com.example.peretz.core.presentation.di.viewModelModule

val allModules = listOf(
    navigationModule,
    viewModelModule
)
