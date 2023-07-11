package com.markaz.currencyconvertor.utils.extenssions

import androidx.lifecycle.ViewModel
import com.markaz.currencyconvertor.utils.helpers.FlowStateProcessorImpl
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.IStateEffectProcessor
import com.markaz.currencyconvertor.utils.interfaces.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 * Creates an `MCC` instance with the provided `prepare` and `onEvent` functions and without state within a [ViewModel].
 *
 * @param EV The type of the event in the `MCC`.
 * @param EF The type of the effect in the `MCC`.
 * @param prepare A suspend function that is executed during the initialization of the `MCC`. It's used to prepare the `MCC` and has no access to the state. Default is an empty lambda.
 * @param onEvent A suspend function that is executed when an event is sent to the `MCC`. Default is an empty lambda.
 * @return An instance of `MCC` with the provided `prepare` and `onEvent` functions.
 */
fun <EV : Any, ST : Any, PA : Intent<ST>, EF : Any> stateEffectProcessor(
    defViewState: ST,
    prepare: suspend (IEffect<EF>) -> Flow<PA> = { emptyFlow() },
    statesEffects: suspend (IEffect<EF>, EV) -> Flow<PA> = { _, _ -> emptyFlow() }
): IStateEffectProcessor<EV, ST, EF> = stateEffectProcessor(
    defViewState,
    prepare,
    statesEffects
)


/**
 * Creates an `MCC` instance with the provided initial state, `prepare` and `onEvent` functions.
 *
 * @param ST The type of the state in the `MCC`.
 * @param EV The type of the event in the `MCC`.
 * @param PA A `PartialState` that represents a partial update of the state.
 * @param EF The type of the effect in the `MCC`.
 * @param initialState The initial state of the `MCC`.
 * @param prepare A suspend function that is executed during the initialization of the `MCC`. Default is an empty lambda that returns an empty flow.
 * @param onEvent A suspend function that is executed when an event is sent to the `MCC`. Default is an empty lambda that returns an empty flow.
 * @return An instance of `MCC` with the provided initial state, `prepare` and `onEvent` functions.
 */
fun <EV : Any, ST : Any, PA : Intent<ST>, EF : Any> CoroutineScope.stateEffectProcessor(
    defViewState: ST,
    prepare: suspend (IEffect<EF>) -> Flow<PA> = { emptyFlow() },
    statesEffects: suspend (IEffect<EF>, EV) -> Flow<PA> = { _, _ -> emptyFlow() },
): IStateEffectProcessor<EV, ST, EF> =
    FlowStateProcessorImpl(this, defViewState, prepare, statesEffects)