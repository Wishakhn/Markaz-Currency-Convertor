package com.markaz.currencyconvertor.ui.composables.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.markaz.currencyconvertor.ui.theme.colorAccentGrey
import com.markaz.currencyconvertor.ui.theme.colorCharcoal
import com.markaz.currencyconvertor.ui.theme.colorGrey
import com.markaz.currencyconvertor.ui.theme.colorSecondaryGrey
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun a_DividerLarge(modifier: Modifier = Modifier) = Spacer(
    modifier = Modifier
        .then(modifier)
        .height(1.sdp)
        .fillMaxWidth()
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorCharcoal,
                    colorGrey,
                    colorSecondaryGrey,
                    colorAccentGrey
                )
            )
        )
)


@Preview
@Composable
fun a_DividerSmall(modifier: Modifier = Modifier) = Spacer(
    modifier = Modifier
        .then(modifier)
        .height(0.5.dp)
        .fillMaxWidth()
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorCharcoal,
                    colorGrey,
                    colorSecondaryGrey,
                    colorAccentGrey
                )
            )
        )
)