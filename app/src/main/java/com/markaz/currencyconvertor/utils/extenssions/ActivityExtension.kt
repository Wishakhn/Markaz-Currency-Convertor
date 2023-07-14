package com.markaz.currencyconvertor.utils.extenssions

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.markaz.currencyconvertor.utils.interfaces.IStateEffectProcessor
import kotlinx.coroutines.flow.Flow

@JvmName("OnResumedStateEffectProcessor")
fun <EV : Any, ST : Any, EF : Any> ComponentActivity.onCreated(
    processor: () -> IStateEffectProcessor<EV, ST, EF>,
    intents: () -> List<Flow<EV>> = { emptyList() },
    onState: (ST) -> Unit = {},
    onEffect: (EF) -> Unit = {}
) = lifecycleScope.launchWhenCreated { this.consume(processor(), onState, onEffect, intents()) }

