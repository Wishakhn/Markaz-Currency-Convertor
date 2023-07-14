package com.markaz.currencyconvertor.domain.usecases

import com.markaz.currencyconvertor.domain.mappers.toCurrencyList
import com.markaz.currencyconvertor.domain.models.CurrencyModel
import com.markaz.currencyconvertor.utils.network.ResponseResource
import com.markaz.currencyconvertor.utils.network.repositories.ICurrencyConverterRespo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchCurrenciesUseCase(private val repository: ICurrencyConverterRespo) {
    suspend operator fun invoke(): Flow<ResponseResource<CurrencyModel>> =
        flow {
            repository.getCurrencies().collect {
                when (it) {
                    is ResponseResource.Error -> emit(ResponseResource.error(it.errorMessage.toCurrencyList()))
                    is ResponseResource.Success -> emit(ResponseResource.success(it.data.toCurrencyList()))
                }
            }
        }
}