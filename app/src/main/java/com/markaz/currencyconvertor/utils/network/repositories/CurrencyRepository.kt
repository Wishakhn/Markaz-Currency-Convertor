package com.markaz.currencyconvertor.utils.network.repositories

import com.markaz.currencyconvertor.data.remote.CurrencyResponse
import com.markaz.currencyconvertor.data.remote.ExchangeRateResponse
import com.markaz.currencyconvertor.utils.network.ResponseResource
import com.markaz.currencyconvertor.utils.network.services.ICurrencyConverterApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CurrencyRepository(
    private val remote: ICurrencyConverterApi
) : ICurrencyConverterRespo {
    override suspend fun getCurrencies(): Flow<ResponseResource<CurrencyResponse>> = flow {
        when (val response = remote.getCurrencies()) {
            is ResponseResource.Error -> emit(ResponseResource.error(response.errorMessage))
            is ResponseResource.Success -> emit(ResponseResource.success(response.data))
        }

    }

    override suspend fun getLatestExchangeRates(): Flow<ResponseResource<ExchangeRateResponse>> =
        flow {
            when (val response = remote.getLatestExchangeRates()) {
                is ResponseResource.Error -> emit(ResponseResource.error(response.errorMessage))
                is ResponseResource.Success -> emit(ResponseResource.success(response.data))
            }
        }
}