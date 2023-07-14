package com.markaz.currencyconvertor.presentation.converter

import androidx.lifecycle.viewModelScope
import com.markaz.currencyconvertor.utils.network.ResponseResource
import com.markaz.currencyconvertor.domain.usecases.FetchCurrenciesUseCase
import com.markaz.currencyconvertor.domain.usecases.FetchExchangeRateUseCase
import com.markaz.currencyconvertor.utils.base.BaseViewModel
import com.markaz.currencyconvertor.utils.extenssions.thenNoAction
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.Intent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class CurrencyViewModel(
    private val currencyUseCase: FetchCurrenciesUseCase,
    private val exchangeUseCase: FetchExchangeRateUseCase
) : BaseViewModel<CCEvent, CCStateModel, CCEffect>() {
    override fun createInitialState(): CCStateModel = CCStateModel()
    override fun handleStateEvents(
        event: CCEvent,
        effect: IEffect<CCEffect>
    ): Flow<Intent<CCStateModel>> {
        return when (event) {
            is CCEvent.RequestCurrencyRates -> fetchCurrencies().thenNoAction()
            is CCEvent.RequestExchangeRates -> fetchExchangeRates().thenNoAction()
            is CCEvent.EnableButton -> flowOf(
                CurrencyStateReducer.UpdateButtonState(
                    event.amount,
                    event.isEnabled
                )
            )
            is CCEvent.UpdateCurrencyApiState -> flowOf(
                CurrencyStateReducer.UpdateCurrencyApiState(
                    event.apiState,
                    event.data
                )
            )
            is CCEvent.UpdateExchangeRateApiState -> flowOf(
                CurrencyStateReducer.UpdateExchangeRateApiState(
                    event.apiState,
                    event.data
                )
            )
            is CCEvent.ConvertCurrencyRate -> flowOf(
                CurrencyStateReducer.ExchangeRateListForSelectedCurrency(
                    amount = event.amount?.toDouble(),
                    sourceCurrency = event.selectedCurrency,
                    list = event.exchangeRateResponse.rateList,
                    baseCurrency = event.exchangeRateResponse.base
                )
            )
            is CCEvent.UpdateSelectedCurrency -> flowOf(CurrencyStateReducer.UpdateSelectedCurrency(event.selectedCurrency))
            else -> emptyFlow()
        }
    }

    private fun fetchCurrencies() =
        viewModelScope.launch {
            currencyUseCase.buildRequest().onStart { }.collect {
                when (it) {
                    is ResponseResource.Success -> {
                        // Set State
                        setEvent(
                            CCEvent.UpdateCurrencyApiState(
                                PostsState.Success(it.data),
                                it.data
                            )
                        )
                    }
                    is ResponseResource.Error -> {
                        // Set Effect
                        setEvent(
                            CCEvent.UpdateCurrencyApiState(
                                PostsState.Error(
                                    it.error.message
                                )
                            )
                        )

                    }
                }
            }
        }

    private fun fetchExchangeRates() = viewModelScope.launch {
        exchangeUseCase.buildRequest().collect {
            when (it) {
                is ResponseResource.Success -> {
                    // Set State
                    setEvent(
                        CCEvent.UpdateExchangeRateApiState(
                            PostsState.Success(it.data),
                            data = it.data
                        )
                    )

                }
                is ResponseResource.Error -> {
                    // Set Effect
                    setEvent(
                        CCEvent.UpdateExchangeRateApiState(
                            PostsState.Error(
                                it.error.message ?: ""
                            )
                        )
                    )

                }
            }
        }
    }

}