package com.markaz.currencyconvertor.utils.di

import com.markaz.currencyconvertor.utils.network.ktorHttpClient
import org.koin.dsl.module


val ktorModule = module {
    single { ktorHttpClient }
}