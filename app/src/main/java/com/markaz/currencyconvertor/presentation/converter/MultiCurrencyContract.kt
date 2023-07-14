package com.markaz.currencyconvertor.presentation.converter

import com.markaz.currencyconvertor.data.local.models.ExchangeRate
import com.markaz.currencyconvertor.domain.models.CurrencyModel
import com.markaz.currencyconvertor.domain.models.ExchangeRateModel
import com.markaz.currencyconvertor.utils.interfaces.IBaseEffects
import com.markaz.currencyconvertor.utils.interfaces.IBaseEvents
import com.markaz.currencyconvertor.utils.interfaces.IBaseStateModel

sealed class CCEvent : IBaseEvents {
    data class EnableButton(val amount: String?, val isEnabled: Boolean) : CCEvent()
    data class UpdateCurrencyApiState(
        val state: PostsState,
        val data: CurrencyModel? = null,
        val error : String?  = ""
    ) : CCEvent()

    data class UpdateExchangeRateApiState(
        val apiState: PostsState,
        val data: ExchangeRateModel? = null,
        val error : String?  = ""
    ) : CCEvent()

    data class UpdateSelectedCurrency(val selectedCurrency: String) : CCEvent()
    data class ConvertCurrencyRate(
        val amount: String?,
        val selectedCurrency: String,
        val exchangeRateResponse: ExchangeRateModel
    ) : CCEvent()

    object RequestCurrencyRates : CCEvent()
    object RequestExchangeRates : CCEvent()
}

sealed class CCEffect : IBaseEffects {
    object NavigateToNext : CCEffect()
}

sealed class PostsState {
    object Idle : PostsState()
    data class Loading(val isLoading : Boolean = false) : PostsState()
}

data class CCStateModel(
    val apiState: PostsState? = null,
    val enableButton: Boolean = false,
    val currencyResponse: CurrencyModel? = null,
    val exchangerateResponse: ExchangeRateModel? = null,
    val amount: String? = null,
    val exchangeRate: List<ExchangeRate>? = listOf(),
    val selectedCurrency: String = "AED",
    val isLoading: Boolean = false
) : IBaseStateModel