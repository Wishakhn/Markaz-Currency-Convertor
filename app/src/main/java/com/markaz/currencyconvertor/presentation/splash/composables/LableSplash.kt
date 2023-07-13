package com.markaz.currencyconvertor.presentation.splash.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextLableLarge
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun LableSplash(modifier: Modifier = Modifier) = a_TextLableLarge(
    text = "MARKAZ \nCURRENCY CONVERTER",
    modifier = Modifier
        .padding(horizontal = 15.sdp, vertical = 10.sdp)
        .then(modifier)
)