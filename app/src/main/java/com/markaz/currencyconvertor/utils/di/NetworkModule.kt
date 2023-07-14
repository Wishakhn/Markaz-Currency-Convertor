package com.markaz.currencyconvertor.utils.di

import com.markaz.currencyconvertor.utils.network.services.CurrencyServiceImpl
import com.markaz.currencyconvertor.utils.network.services.ICurrencyConverterApi
import org.koin.dsl.module

/**
 * Network module
 * This DI module will be responsible of providing network dependencies
 * which need to be live as long as app is living
 * @constructor Create empty Network module
 */
val networkModule = module {
    single<ICurrencyConverterApi> { CurrencyServiceImpl(get()) }
}