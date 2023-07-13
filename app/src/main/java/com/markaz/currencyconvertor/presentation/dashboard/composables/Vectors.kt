package com.markaz.currencyconvertor.presentation.dashboard.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.presentation.dashboard.ConnversionOptions
import com.markaz.currencyconvertor.ui.theme.colorAccentMustard
import com.markaz.currencyconvertor.ui.theme.colorAccentPurple
import com.markaz.currencyconvertor.ui.theme.colorPrimaryDark
import com.markaz.currencyconvertor.ui.theme.colorPrimaryGrey
import com.markaz.currencyconvertor.ui.theme.colorPrimaryMustard
import com.markaz.currencyconvertor.ui.theme.colorPrimaryPurple
import com.markaz.currencyconvertor.ui.theme.colorSecondaryGrey
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp


@Preview
@Composable
fun LogoCard(modifier: Modifier = Modifier) = Image(
    painter = painterResource(id = R.drawable.ic_exchange),
    contentDescription = "",
    modifier = Modifier
        .padding(top = 20.sdp, end = 7.sdp)
        .size(40.sdp)
        .then(modifier),
    colorFilter = ColorFilter.tint(colorPrimaryDark)
)


@Preview
@Composable
fun ArrowCard(modifier: Modifier = Modifier) = Image(
    painter = painterResource(id = R.drawable.ic_arrow_ip),
    contentDescription = "",
    modifier = Modifier
        .padding(top = 15.sdp)
        .then(modifier),
    colorFilter = ColorFilter.tint(colorPrimaryDark)
)

@Preview
@Composable
fun OptIcon(
    modifier: Modifier = Modifier, option: ConnversionOptions = ConnversionOptions.SingleConversion
) = Image(
    painter = painterResource(id = if (option == ConnversionOptions.SingleConversion) R.drawable.ic_single_currency else R.drawable.ic_multi_currency),
    contentDescription = "",
    colorFilter = ColorFilter.tint(colorWhite),
    modifier = Modifier
        .padding(top = 15.sdp)
        .size(40.sdp)
        .background(
            color = if (option == ConnversionOptions.SingleConversion) colorPrimaryPurple else colorPrimaryMustard,
            shape = RoundedCornerShape(10.sdp)
        )
        .border(
            1.sdp,
            color = if (option == ConnversionOptions.SingleConversion) colorSecondaryGrey else colorPrimaryGrey,
            shape = RoundedCornerShape(10.sdp)
        )
        .padding(4.sdp)
        .then(modifier)
)


fun getGradient(option: ConnversionOptions): List<Color> =
    if (option == ConnversionOptions.SingleConversion) listOf(
        colorWhite, colorWhite, colorAccentPurple
    )
    else {
        listOf(
            colorWhite, colorWhite, colorAccentMustard
        )
    }


fun getGradientStroke(option: ConnversionOptions): List<Color> =
    if (option == ConnversionOptions.SingleConversion) listOf(
        colorWhite, colorAccentPurple
    )
    else {
        listOf(
            colorWhite, colorAccentMustard
        )
    }