package com.markaz.currencyconvertor.utils.extenssions

import com.markaz.currencyconvertor.utils.interfaces.Intent
import kotlinx.coroutines.flow.MutableStateFlow

fun <T : Intent<K>, K : Any> MutableStateFlow<K>.reduceAndSet(intent: T) {
    value = intent.reduce(value)
}
