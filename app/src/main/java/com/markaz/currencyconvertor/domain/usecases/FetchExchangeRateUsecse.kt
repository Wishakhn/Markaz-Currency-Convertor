package com.markaz.currencyconvertor.domain.usecases

import com.markaz.currencyconvertor.domain.mappers.toExchangeRate
import com.markaz.currencyconvertor.domain.models.ExchangeRateModel
import com.markaz.currencyconvertor.utils.network.ResponseResource
import com.markaz.currencyconvertor.utils.network.repositories.ICurrencyConverterRespo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchExchangeRateUseCase(private val repository: ICurrencyConverterRespo) {
    suspend fun buildRequest(): Flow<ResponseResource<ExchangeRateModel>> = flow {
        repository.getLatestExchangeRates().collect {
            when (it) {
                is ResponseResource.Success -> emit(ResponseResource.success(it.data.toExchangeRate()))
                is ResponseResource.Error -> emit(ResponseResource.error(it.errorMessage.toExchangeRate()))
            }
        }
    }
}