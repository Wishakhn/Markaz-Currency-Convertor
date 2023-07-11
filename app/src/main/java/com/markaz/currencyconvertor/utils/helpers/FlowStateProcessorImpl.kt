package com.markaz.currencyconvertor.utils.helpers

import com.markaz.currencyconvertor.utils.extenssions.reduceAndSet
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.IStateEffectProcessor
import com.markaz.currencyconvertor.utils.interfaces.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class FlowStateProcessorImpl<in EV : Any, ST : Any, out PA : Intent<ST>, EF : Any> constructor(
    private val scope: CoroutineScope,
    initialState: ST,
    prepare: (suspend (IEffect<EF>) -> Flow<PA>)? = null,
    private val onEvent: (suspend (IEffect<EF>, EV) -> Flow<PA>)? = null,
) : IStateEffectProcessor<EV, ST, EF> {

    override val effect: Flow<EF>
        get() = effectSharedFlow
    private val effectSharedFlow: MutableSharedFlow<EF> = MutableSharedFlow(replay = 0)

    override val state: StateFlow<ST>
        get() = stateFlow
    private val stateFlow: MutableStateFlow<ST> = MutableStateFlow(initialState)

    private val effectsCollector: IEffect<EF> = object : IEffect<EF> {
        override fun send(effect: EF) {
            scope.launch { effectSharedFlow.emit(effect) }
        }
    }

    init {
        prepare?.let {
            scope.launch {
                it(effectsCollector).collect { stateFlow.reduceAndSet(it) }
            }
        }
    }

    override fun sendEvent(event: EV) {
        onEvent?.let {
            scope.launch { it(effectsCollector, event).collect { stateFlow.reduceAndSet(it) } }
        }
    }
}
