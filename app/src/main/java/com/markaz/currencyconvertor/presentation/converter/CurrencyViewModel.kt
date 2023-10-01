package com.markaz.currencyconvertor.presentation.converter

import androidx.lifecycle.viewModelScope
import com.markaz.currencyconvertor.domain.usecases.FetchCurrenciesUseCase
import com.markaz.currencyconvertor.domain.usecases.FetchExchangeRateUseCase
import com.markaz.currencyconvertor.utils.base.BaseViewModel
import com.markaz.currencyconvertor.utils.extenssions.thenNoAction
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.Intent
import com.markaz.currencyconvertor.utils.network.ResponseResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CurrencyViewModel(
    private val currencyUseCase: FetchCurrenciesUseCase,
    private val exchangeUseCase: FetchExchangeRateUseCase
) : BaseViewModel<CCEvent, CCStateModel, CCEffect>() {
    override fun createInitialState(): CCStateModel = CCStateModel()

    // Coroutines Flow
   private var  _isButtonEnabled : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isButtonEnabled : StateFlow<Boolean> =  _isButtonEnabled.asStateFlow()
    override fun handleStateEvents(
        event: CCEvent,
        effect: IEffect<CCEffect>
    ): Flow<Intent<CCStateModel>> {
        return when (event) {
            is CCEvent.RequestCurrencyRates -> fetchCurrencies().thenNoAction()
            is CCEvent.RequestExchangeRates -> fetchExchangeRates().thenNoAction()
            is CCEvent.EnableButton -> {
               _isButtonEnabled.update { true }
                flowOf(
                    CurrencyStateReducer.UpdateButtonState(
                        event.amount,
                        event.isEnabled
                    )
                )
            }

            is CCEvent.UpdateCurrencyApiState -> flowOf(
                CurrencyStateReducer.UpdateCurrencyApiState(
                    state = event.state,
                    data = event.data,
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

            is CCEvent.UpdateSelectedCurrency -> flowOf(
                CurrencyStateReducer.UpdateSelectedCurrency(
                    event.selectedCurrency
                )
            )
        }
    }

    private fun fetchCurrencies() =
        viewModelScope.launch {
            setEvent(
                CCEvent.UpdateCurrencyApiState(
                    state = PostsState.Loading(true)
                )
            )
            currencyUseCase().collect {
                when (it) {
                    is ResponseResource.Success -> {
                        // Set State
                        setEvent(
                            CCEvent.UpdateCurrencyApiState(
                                state = PostsState.Loading(false),
                                data = it.data
                            )
                        )
                    }

                    is ResponseResource.Error -> {
                        // Set Effect
                        setEvent(
                            CCEvent.UpdateCurrencyApiState(
                                state = PostsState.Loading(false),
                                error = it.errorMessage.error?.message
                            )
                        )

                    }
                }
            }
        }

    private fun fetchExchangeRates() = viewModelScope.launch {
        exchangeUseCase().collect {
            when (it) {
                is ResponseResource.Success -> {
                    // Set State
                    setEvent(
                        CCEvent.UpdateExchangeRateApiState(
                            apiState = PostsState.Loading(false),
                            data = it.data
                        )
                    )

                }

                is ResponseResource.Error -> {
                    // Set Effect
                    setEvent(
                        CCEvent.UpdateExchangeRateApiState(
                            apiState = PostsState.Loading(false),
                            error = it.errorMessage.error
                        )
                    )

                }
            }
        }
    }

}