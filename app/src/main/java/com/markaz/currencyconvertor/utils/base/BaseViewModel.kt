package com.markaz.currencyconvertor.utils.base


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markaz.currencyconvertor.utils.helpers.FlowStateProcessorImpl
import com.markaz.currencyconvertor.utils.interfaces.IBaseEffects
import com.markaz.currencyconvertor.utils.interfaces.IBaseEvents
import com.markaz.currencyconvertor.utils.interfaces.IBaseStateModel
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.IStateEffectProcessor
import com.markaz.currencyconvertor.utils.interfaces.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : IBaseEvents, State : IBaseStateModel, Effect : IBaseEffects> :
    ViewModel() {
    private val initialState: State by lazy { createInitialState() }
    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    private val uiState = _uiState.asStateFlow()
    private val currentState: State
        get() = uiState.value
    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()
    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()
    private val stateProcessor: IStateEffectProcessor<Event, State, Effect> = stateEffectProcessor(
        defViewState = _uiState.value,
        prepare = { emptyFlow() },
        statesEffects = { effects, ev ->
            handleStateEvents(ev, effects)
        }
    )

    fun getStateProcessor() = stateProcessor

    abstract fun createInitialState(): State

    abstract fun handleStateEvents(event: Event, effect: IEffect<Effect>): Flow<Intent<State>>

    /**
     * Set new Event
     */
    fun setEvent(event: Event) {
        val newEvent = event
        viewModelScope.launch { stateProcessor.sendEvent(newEvent) }
    }


    /**
     * Set new Ui State
     */
    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    /**
     * Set new Effect
     */
    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    fun <EV : Any, ST : Any, PA : Intent<ST>, EF : Any> stateEffectProcessor(
        defViewState: ST,
        prepare: suspend (IEffect<EF>) -> Flow<PA> = { emptyFlow() },
        statesEffects: suspend (IEffect<EF>, EV) -> Flow<PA> = { _, _ -> emptyFlow() }
    ): IStateEffectProcessor<EV, ST, EF> = viewModelScope.stateEffectProcessor(
        defViewState,
        prepare,
        statesEffects
    )


    fun <EV : Any, ST : Any, PA : Intent<ST>, EF : Any> CoroutineScope.stateEffectProcessor(
        defViewState: ST,
        prepare: suspend (IEffect<EF>) -> Flow<PA> = { emptyFlow() },
        statesEffects: suspend (IEffect<EF>, EV) -> Flow<PA> = { _, _ -> emptyFlow() },
    ): IStateEffectProcessor<EV, ST, EF> =
        FlowStateProcessorImpl(this, defViewState, prepare, statesEffects)

}