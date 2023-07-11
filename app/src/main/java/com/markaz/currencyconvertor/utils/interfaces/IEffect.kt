package com.markaz.currencyconvertor.utils.interfaces

/**
 * Represents an effects collector that can send effects of a specified type.
 *
 * This interface is used to define a collector that is responsible for emitting effects within an `MCC app` context.
 * It provides a `send` method for emitting one or more effects of a specific type.
 *
 * @param T The type of the effect that can be sent by the collector.
 */
interface IEffect<T : Any> {

    /**
     * Sends one or more effects of the specified type.
     *
     * This method is used to emit effects within an `MCC` context.
     *
     * @param effect A vararg parameter containing one or more effects of type [T] to be sent.
     */
    fun send(effect: T)
}
