package com.markaz.currencyconvertor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.markaz.currencyconvertor.data.local.localservice.ExchangeLocalDao
import com.markaz.currencyconvertor.data.local.entities.CurrencyEntity
import com.task.currencyapp.data.local.entities.ExchangeRateEntity

@Database(
    entities = [CurrencyEntity::class, ExchangeRateEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverter::class)
abstract class MCCLocalDB : RoomDatabase() {
    abstract fun exchangeLocalDao(): ExchangeLocalDao
}