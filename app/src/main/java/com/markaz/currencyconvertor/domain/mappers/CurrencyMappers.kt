package com.markaz.currencyconvertor.domain.mappers

import com.markaz.currencyconvertor.data.local.models.Currency
import com.markaz.currencyconvertor.data.local.models.ExchangeRate
import com.markaz.currencyconvertor.data.remote.CurrencyResponse
import com.markaz.currencyconvertor.data.remote.ExchangeRateResponse
import com.markaz.currencyconvertor.domain.models.CurrencyModel
import com.markaz.currencyconvertor.domain.models.ExchangeRateModel


fun ExchangeRateResponse.toExchangeRate() = ExchangeRateModel(
    base ?: "", rates?.map { ExchangeRate(it.key, it.value) } ?: listOf(),
    error = if (rates.isNullOrEmpty()) "Opps something went wrong" else ""
)

fun CurrencyResponse.toCurrencyList() = CurrencyModel(
    currencies?.map { Currency(it.key, it.value) } ?: listOf(),
    error = error
)