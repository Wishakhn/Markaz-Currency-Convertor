package com.markaz.currencyconvertor.utils.di

import com.markaz.currencyconvertor.domain.usecases.FetchCurrenciesUseCase
import com.markaz.currencyconvertor.domain.usecases.FetchExchangeRateUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    single {
        FetchCurrenciesUseCase(get())
    }
    single {
        FetchExchangeRateUseCase(get())
    }
}