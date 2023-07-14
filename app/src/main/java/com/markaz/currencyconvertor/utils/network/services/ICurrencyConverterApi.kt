package com.markaz.currencyconvertor.utils.network.services

import com.markaz.currencyconvertor.data.remote.ExchangeRateResponse
import com.markaz.currencyconvertor.utils.network.ResponseResource

interface ICurrencyConverterApi {
    suspend fun getCurrencies(): ResponseResource<Map<String, String>>
    suspend fun getLatestExchangeRates(): ResponseResource<ExchangeRateResponse>
}