package com.markaz.currencyconvertor.domain.models

import com.markaz.currencyconvertor.data.local.models.Currency
import com.markaz.currencyconvertor.utils.network.ApiError

data class CurrencyModel(
    val currencies: List<Currency>,
    val error : ApiError?
)
