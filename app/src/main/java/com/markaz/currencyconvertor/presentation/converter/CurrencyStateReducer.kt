package com.markaz.currencyconvertor.presentation.converter

import com.markaz.currencyconvertor.data.local.models.ExchangeRate
import com.markaz.currencyconvertor.domain.models.CurrencyModel
import com.markaz.currencyconvertor.domain.models.ExchangeRateModel
import com.markaz.currencyconvertor.utils.interfaces.Intent

sealed class CurrencyStateReducer : Intent<CCStateModel> {
    data class UpdateCurrencyApiState(val state: PostsState, val data: CurrencyModel?) :
        CurrencyStateReducer() {
        override fun reduce(oldState: CCStateModel): CCStateModel {
            return when (state) {
                is PostsState.Loading -> {
                    if (state.isLoading) {
                        oldState.copy(
                            isLoading = state.isLoading,
                            apiState = state
                        )
                    } else oldState.copy(
                        apiState = state,
                        currencyResponse = data,
                        isLoading = state.isLoading
                    )
                }

                else -> oldState.copy(apiState = state)
            }

        }
    }

    data class UpdateExchangeRateApiState(val state: PostsState, val data: ExchangeRateModel?) :
        CurrencyStateReducer() {
        override fun reduce(oldState: CCStateModel): CCStateModel {
            return when (state) {
                is PostsState.Loading -> {
                    if (state.isLoading) {
                        oldState.copy(
                            isLoading = true,
                            apiState = state
                        )
                    } else oldState.copy(
                        apiState = state,
                        exchangerateResponse = data
                    )
                }

                else -> oldState.copy(apiState = state)
            }

        }
    }

    data class UpdateButtonState(val amount: String?, val isEnabled: Boolean) :
        CurrencyStateReducer() {
        override fun reduce(oldState: CCStateModel): CCStateModel {
            return when {
                amount?.isNotBlank() == true -> oldState.copy(
                    amount = amount,
                    enableButton = isEnabled
                )

                else -> oldState.copy(enableButton = isEnabled)
            }

        }

    }

    data class UpdateSelectedCurrency(val selectedCurrency: String) : CurrencyStateReducer() {
        override fun reduce(oldState: CCStateModel): CCStateModel =
            oldState.copy(selectedCurrency = selectedCurrency)
    }

    data class ExchangeRateListForSelectedCurrency(
        val list: List<ExchangeRate>?,
        val amount: Double?,
        val sourceCurrency: String?,
        val baseCurrency: String
    ) : CurrencyStateReducer() {
        override fun reduce(oldState: CCStateModel): CCStateModel {
            val newList = if (isCurrencyAndAmountValid(amount, sourceCurrency)) {
                list?.map { rate ->
                    ExchangeRate(
                        exchangeRate = convertExchangeRate(
                            source = list.find { exchangeRate -> exchangeRate.currencyCode == sourceCurrency },
                            destination = rate,
                            amount = amount,
                            isBaseSame = sourceCurrency == baseCurrency
                        ),
                        currencyCode = rate.currencyCode
                    )
                } ?: emptyList()
            } else {
                emptyList()
            }
            return oldState.copy(exchangeRate = newList)
        }
    }

    internal fun convertExchangeRate(
        source: ExchangeRate?,
        destination: ExchangeRate,
        amount: Double?,
        isBaseSame: Boolean
    ): Double =
        if (isBaseSame)
            covertWithSameBase(
                amount = amount ?: 0.0,
                destinationRate = destination.exchangeRate
            )
        else
            covertWithNotSameBase(
                destinationRate = destination.exchangeRate,
                sourceRate = source?.exchangeRate ?: 0.0,
                amount = amount ?: 0.0
            )


    private fun covertWithNotSameBase(
        destinationRate: Double,
        sourceRate: Double,
        amount: Double
    ): Double =
        (destinationRate.div(sourceRate) * amount)


    private fun covertWithSameBase(
        destinationRate: Double,
        amount: Double
    ): Double = (destinationRate * amount)


    internal fun isCurrencyAndAmountValid(amount: Double?, selectedCurrency: String?): Boolean =
        amount != null && !selectedCurrency.isNullOrBlank()

}