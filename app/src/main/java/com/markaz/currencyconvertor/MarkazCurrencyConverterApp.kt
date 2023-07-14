package com.markaz.currencyconvertor

import android.app.Application
import com.markaz.currencyconvertor.utils.di.ktorModule
import com.markaz.currencyconvertor.utils.di.networkModule
import com.markaz.currencyconvertor.utils.di.repositoryModule
import com.markaz.currencyconvertor.utils.di.useCaseModule
import com.markaz.currencyconvertor.utils.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarkazCurrencyConverterApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarkazCurrencyConverterApp)
            modules(ktorModule + networkModule + repositoryModule + useCaseModule + viewModelModule)
        }
    }

}