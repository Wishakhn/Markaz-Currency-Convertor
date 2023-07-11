package com.markaz.currencyconvertor.utils.interfaces

import kotlinx.coroutines.flow.StateFlow

/**
 * Represents an `IStateProcessor`, a state management system with event handling.
 *
 * This interface defines a `Processor` that can handle events, manage state.
 * It exposes the current state as a [StateFlow], and provides a `sendEvent` method to send events.
 *
 * @param EV The type of the event that the `Processor` can handle.
 * @param ST The type of the state managed by the `Processor`.
 */
interface IStateProcessor<in EV : Any, out ST : Any> {
    val state: StateFlow<ST>
    fun sendEvent(event: EV)
}
