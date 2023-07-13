package com.markaz.currencyconvertor.data.local.models

data class CurrencyDao(
    val currencies: List<Currency>
)

data class Currency(
    val currencyCode: String,
    val currencyName: String,
)