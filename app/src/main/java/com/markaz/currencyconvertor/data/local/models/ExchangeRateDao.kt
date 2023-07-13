package com.markaz.currencyconvertor.data.local.models


data class ExchangeRateDao(
    val base: String,
    val rateList: List<ExchangeRate>
)

data class ExchangeRate(
    val currencyCode: String,
    val exchangeRate: Double,
)

