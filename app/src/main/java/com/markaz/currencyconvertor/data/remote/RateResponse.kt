package com.markaz.currencyconvertor.data.remote

import com.google.gson.annotations.SerializedName
import com.markaz.currencyconvertor.utils.network.ApiError

data class ExchangeRateResponse(
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("rates")
    val rates: Map<String, Double>? = null,
    val error: ApiError? = null,
)
