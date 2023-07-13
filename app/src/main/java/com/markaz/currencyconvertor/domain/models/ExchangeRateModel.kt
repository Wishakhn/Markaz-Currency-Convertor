package com.markaz.currencyconvertor.domain.models

import com.markaz.currencyconvertor.data.local.models.ExchangeRate

data class ExchangeRateModel(
    val base: String,
    val rateList: List<ExchangeRate>
)