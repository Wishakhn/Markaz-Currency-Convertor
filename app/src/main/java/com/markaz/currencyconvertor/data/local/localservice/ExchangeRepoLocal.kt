package com.markaz.currencyconvertor.data.local.localservice

import com.markaz.currencyconvertor.data.local.entities.CurrencyEntity
import com.task.currencyapp.data.local.entities.ExchangeRateEntity


class ExchangeRepoLocal constructor(private val exchangeLocalDao: ExchangeLocalDao) :
    ExchangeRepoDbService {
    override suspend fun getCurrencies(): List<CurrencyEntity>? = exchangeLocalDao.getAllCurrencies()

    override suspend fun insertCurrencies(currencies: List<CurrencyEntity>) =
        exchangeLocalDao.insertAllCurrencies(currencies)

    override suspend fun getExchangeRates(): List<ExchangeRateEntity>? =
        exchangeLocalDao.getAllRates()

    override suspend fun insertExchangeRates(rates: List<ExchangeRateEntity>) =
        exchangeLocalDao.insertRates(rates)

}