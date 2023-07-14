package com.markaz.currencyconvertor.presentation.converter.multiconverter.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.markaz.currencyconvertor.presentation.converter.CCEffect
import com.markaz.currencyconvertor.presentation.converter.CCEvent
import com.markaz.currencyconvertor.presentation.converter.CCStateModel
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextBodyLarge
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextDisplayMedium
import com.markaz.currencyconvertor.utils.extenssions.collectAsState
import com.markaz.currencyconvertor.utils.extenssions.roundToThreeDeci
import com.markaz.currencyconvertor.utils.interfaces.IStateEffectProcessor
import ir.kaaveh.sdpcompose.sdp

@Composable
fun ExhcangedCurrencyList(
    modifier: Modifier,
    processor: IStateEffectProcessor<CCEvent, CCStateModel, CCEffect>,
) {
    val exhcnagedCurrencyList = processor.collectAsState { it.exchangeRate }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.sdp)
            .then(modifier)

    ) {
        items(exhcnagedCurrencyList.value ?: listOf()) { item ->
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(bottom = 3.sdp)
            ) {
                a_TextDisplayMedium(
                    text = item.currencyCode, modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 10.sdp)
                )

                a_TextBodyLarge(
                    text = item.exchangeRate.roundToThreeDeci().toString(), modifier = Modifier
                        .wrapContentSize()
                )
            }
        }
    }
}