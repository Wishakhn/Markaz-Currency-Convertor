package com.markaz.currencyconvertor.presentation.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.presentation.dashboard.ConnversionOptions
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextBodyLarge
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextDisplayLarge
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextDisplaySmall
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextTitleLarge
import com.markaz.currencyconvertor.ui.theme.authLoginNote
import com.markaz.currencyconvertor.ui.theme.colorGradientPurple
import com.markaz.currencyconvertor.ui.theme.colorPrimaryGrey
import com.markaz.currencyconvertor.ui.theme.colorSecondaryMustard
import com.markaz.currencyconvertor.ui.theme.colorSecondaryPurple
import com.markaz.currencyconvertor.ui.theme.multiCurrencyConvertorTitle
import com.markaz.currencyconvertor.ui.theme.singleCurrencyConvertorTitle
import ir.kaaveh.sdpcompose.sdp


@Preview
@Composable
fun TitleDashboardCard(modifier: Modifier = Modifier) = a_TextBodyLarge(
    text = authLoginNote,
    modifier = Modifier
        .padding(top = 20.sdp)
        .then(modifier)
)

@Preview
@Composable
fun LabelDashboardCard(modifier: Modifier = Modifier) = a_TextBodyLarge(
    text = "Today's Rate",
    modifier = Modifier
        .padding(top = 20.sdp)
        .then(modifier),
    align = TextAlign.Start
)

@Preview
@Composable
fun RatesDashboardCard(modifier: Modifier = Modifier) = a_TextTitleLarge(
    text = "1 USD = 230 PKR",
    modifier = Modifier
        .padding(top = 5.sdp)
        .then(modifier),
    align = TextAlign.Start
)

@Preview
@Composable
fun PercentageCard(modifier: Modifier = Modifier) =
    a_TextDisplayLarge(
        text = "8.2%",
        modifier = Modifier
            .padding(start = 5.sdp, top = 15.sdp)
            .wrapContentWidth()
            .then(modifier)
    )

@Preview
@Composable
fun OptTitleText(
    modifier: Modifier = Modifier,
    option: ConnversionOptions = ConnversionOptions.SingleConversion,
) =
    a_TextDisplayLarge(
        text = if (option == ConnversionOptions.SingleConversion) singleCurrencyConvertorTitle else multiCurrencyConvertorTitle, modifier = Modifier
            .padding(start = 5.sdp, top = 15.sdp)
            .then(modifier),
        color = if (option == ConnversionOptions.SingleConversion) colorSecondaryPurple else colorSecondaryMustard,
        align = TextAlign.Start
    )

@Preview
@Composable
fun OptTypeText(
    modifier: Modifier = Modifier,
    option: ConnversionOptions = ConnversionOptions.SingleConversion
) =
    a_TextDisplaySmall(
        text = "Free", modifier = Modifier
            .padding(top = 5.sdp)
            .wrapContentWidth()
            .background(
                if (option == ConnversionOptions.SingleConversion) colorGradientPurple else colorPrimaryGrey,
                shape = RoundedCornerShape(2.sdp)
            )
            .padding(horizontal = 3.sdp, vertical = 1.sdp)
            .then(modifier),
        color = colorSecondaryPurple
    )

@Preview
@Composable
fun OptClickText(
    modifier: Modifier = Modifier,
    option: ConnversionOptions = ConnversionOptions.SingleConversion
) =
    a_TextDisplaySmall(
        text = "Convert", modifier = Modifier
            .padding(top = 25.sdp)
            .then(modifier),
        color = if (option == ConnversionOptions.SingleConversion) colorSecondaryPurple else colorSecondaryMustard
    )

