package com.markaz.currencyconvertor.utils.extenssions

import com.markaz.currencyconvertor.utils.interfaces.Intent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


fun <T : Any> NoAction(): Intent<T> = object : Intent<T> {
    override fun reduce(oldState: T): T = oldState
}

fun <T : Any> Any.thenNoAction(): Flow<Intent<T>> = flowOf(NoAction())
