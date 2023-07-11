package com.markaz.currencyconvertor.utils.interfaces

import kotlinx.coroutines.flow.Flow

interface IEffectProcessor<in EV : Any, out EF : Any> {
    val effect: Flow<EF>
    fun sendEvent(event: EV)
}
