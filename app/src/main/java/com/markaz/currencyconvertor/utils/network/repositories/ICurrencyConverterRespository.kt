package com.markaz.currencyconvertor.utils.network.repositories

import com.markaz.currencyconvertor.data.remote.CurrencyResponse
import com.markaz.currencyconvertor.data.remote.ExchangeRateResponse
import com.markaz.currencyconvertor.utils.network.ResponseResource
import kotlinx.coroutines.flow.Flow

interface ICurrencyConverterRespo {
    suspend fun getCurrencies(): Flow<ResponseResource<CurrencyResponse>>
    suspend fun getLatestExchangeRates(): Flow<ResponseResource<ExchangeRateResponse>>
}