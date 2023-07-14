package com.markaz.currencyconvertor.utils.network.services

import com.markaz.currencyconvertor.data.remote.CurrencyResponse
import com.markaz.currencyconvertor.data.remote.ExchangeRateResponse
import com.markaz.currencyconvertor.utils.network.ApiError
import com.markaz.currencyconvertor.utils.network.ResponseResource
import com.markaz.currencyconvertor.utils.network.URL_GET_CURRENCIES
import com.markaz.currencyconvertor.utils.network.URL_GET_RATES
import com.markaz.currencyconvertor.utils.network.apikey
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody

class CurrencyServiceImpl(private val client: HttpClient) : ICurrencyConverterApi{

    override suspend fun getCurrencies(): ResponseResource<CurrencyResponse> = try {
        val response = client.get(URL_GET_CURRENCIES) {
        }.body<CurrencyResponse>()
        when (response.currencies) {
            null -> ResponseResource.error(response)
            else -> ResponseResource.success(response)
        }
    } catch (e: Exception) {
        ResponseResource.error(
            CurrencyResponse
                (error = ApiError(4422,"Oops, Looks like something's wrong check your internet connection"))
        )
    }


    override suspend fun getLatestExchangeRates(): ResponseResource<ExchangeRateResponse> = try {
        val response = client.get(URL_GET_RATES){
            parameter("app_id", apikey)
        }.body<ExchangeRateResponse>()
        when (response) {
            null -> ResponseResource.error(response)
            else -> ResponseResource.success(response)
        }
    }
    catch (e: Exception) {
        ResponseResource.error(
            ExchangeRateResponse
                (error = ApiError(4422,"Oops, Looks like something's wrong check your internet connection"))
        )
    }


}