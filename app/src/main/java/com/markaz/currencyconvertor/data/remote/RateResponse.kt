package com.markaz.currencyconvertor.data.remote

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateResponse(
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("rates")
    val rates: Map<String, Double>? = null
)
