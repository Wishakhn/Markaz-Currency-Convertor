package com.markaz.currencyconvertor.utils.di

import com.markaz.currencyconvertor.presentation.converter.CurrencyViewModel
import com.markaz.currencyconvertor.presentation.dashboard.DashboardViewModel
import com.markaz.currencyconvertor.presentation.splash.SplashViewModel
import com.markaz.currencyconvertor.presentation.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel { CurrencyViewModel(get(), get()) }
    viewModel { SplashViewModel() }
    viewModel { WelcomeViewModel() }
    viewModel { DashboardViewModel() }


}