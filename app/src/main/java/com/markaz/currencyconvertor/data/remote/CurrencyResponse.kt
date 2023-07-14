package com.markaz.currencyconvertor.data.remote

import com.google.gson.annotations.SerializedName
import com.markaz.currencyconvertor.utils.network.ApiError
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponse(
    @SerializedName("currencies")
    val currencies: Map<String, String>? = null,
    val error: ApiError? = null,
)
