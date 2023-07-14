package com.markaz.currencyconvertor.utils.network.services

import com.markaz.currencyconvertor.data.remote.CurrencyResponse
import com.markaz.currencyconvertor.data.remote.ExchangeRateResponse
import com.markaz.currencyconvertor.utils.network.ResponseResource

interface ICurrencyConverterApi {
    suspend fun getCurrencies(): ResponseResource<CurrencyResponse>
    suspend fun getLatestExchangeRates(): ResponseResource<ExchangeRateResponse>
}