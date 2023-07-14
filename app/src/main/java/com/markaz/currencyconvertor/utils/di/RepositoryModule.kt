package com.markaz.currencyconvertor.utils.di

import com.markaz.currencyconvertor.utils.network.repositories.CurrencyRepository
import com.markaz.currencyconvertor.utils.network.repositories.ICurrencyConverterRespo
import org.koin.dsl.module

/**
 * Repositories module
 * This DI module will be responsible of providing repositories dependencies
 * which need to be live as long as app is living
 * @constructor Create empty Repositories module
 */
val repositoryModule = module {
    single<ICurrencyConverterRespo> { CurrencyRepository(get()) }
    //   single<ChatRepository> { ChatRepositoryImpl(get(), get()) }
}