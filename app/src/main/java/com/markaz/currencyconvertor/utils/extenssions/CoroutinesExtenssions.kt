package com.markaz.currencyconvertor.utils.extenssions

import com.markaz.currencyconvertor.utils.interfaces.IEffectProcessor
import com.markaz.currencyconvertor.utils.interfaces.IStateEffectProcessor
import com.markaz.currencyconvertor.utils.interfaces.IStateProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

fun <EV : Any, ST : Any> CoroutineScope.consume(
    processor: IStateProcessor<EV, ST>,
    render: (ST) -> Unit,
    viewEvents: List<Flow<EV>> = emptyList()
) {
    launch { processor.onState(render) }
    launch { processor.process(viewEvents) }
}

fun <EV : Any, EF : Any, ST : Any> CoroutineScope.consume(
    processor: IStateEffectProcessor<EV, ST, EF>,
    render: (ST) -> Unit,
    trigger: (EF) -> Unit,
    viewEvents: List<Flow<EV>> = emptyList()
) {
    launch { processor.onState(render) }
    launch { processor.onEffect(trigger) }
    launch { processor.process(viewEvents) }
}

fun <EV : Any, EF : Any> CoroutineScope.consume(
    processor: IEffectProcessor<EV, EF>,
    trigger: (EF) -> Unit,
    viewEvents: List<Flow<EV>> = emptyList()
) {
    launch { processor.onEffect(trigger) }
    launch { processor.process(viewEvents) }
}

suspend fun <EV : Any, ST : Any> IStateProcessor<EV, ST>.process(
    viewEvents: List<Flow<EV>> = emptyList()
) = viewEvents.mergeEvents().collect { event -> sendEvent(event) }

 suspend fun <EV : Any, EF : Any> IEffectProcessor<EV, EF>.process(
    viewEvents: List<Flow<EV>> = emptyList()
) = viewEvents.mergeEvents().collect { event -> sendEvent(event) }

 suspend fun <EV : Any, ST : Any> IStateProcessor<EV, ST>.onState(
    render: (ST) -> Unit
): FlowCollector<ST> = state.collect { state -> render(state) }

 suspend fun <EV : Any, ST : Any, EF : Any> IStateEffectProcessor<EV, ST, EF>.onEffect(
    trigger: (EF) -> Unit
) = effect.collect { effect -> trigger(effect) }

internal suspend fun <EV : Any, EF : Any> IEffectProcessor<EV, EF>.onEffect(
    trigger: (EF) -> Unit
) = effect.collect { effect -> trigger(effect) }
