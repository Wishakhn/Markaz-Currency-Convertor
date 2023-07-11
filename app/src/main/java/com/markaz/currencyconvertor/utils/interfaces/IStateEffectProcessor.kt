package com.markaz.currencyconvertor.utils.interfaces

import kotlinx.coroutines.flow.Flow

/**
 ** Represents an `IStateEffectProcessor`, a state management system for effects.
 * This interface defines a `Processor` that can emit effects.
 * It exposes the current effects as a [Flow]
 ** @param EF The type of the effect emitted by the `Processor`.
 */
interface IStateEffectProcessor<in EV : Any, out ST : Any, out EF : Any> : IStateProcessor<EV, ST> {
    val effect: Flow<EF>
}
