package com.markaz.currencyconvertor.domain.models

import com.markaz.currencyconvertor.data.local.models.ExchangeRate
import com.markaz.currencyconvertor.utils.network.ApiError

data class ExchangeRateModel(
    val base: String,
    val rateList: List<ExchangeRate>,
    val error : ApiError?
)