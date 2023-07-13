package com.markaz.currencyconvertor.ui.composables.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.ui.theme.colorAccentGrey
import com.markaz.currencyconvertor.ui.theme.colorFadeSecondaryLight
import com.markaz.currencyconvertor.ui.theme.colorGradientGreyBlue
import com.markaz.currencyconvertor.ui.theme.colorGradientLightBlue
import com.markaz.currencyconvertor.ui.theme.colorGrey
import com.markaz.currencyconvertor.ui.theme.colorSecondaryGrey
import com.markaz.currencyconvertor.ui.theme.colorWhite
import com.markaz.currencyconvertor.ui.theme.mccTypography
import ir.kaaveh.sdpcompose.sdp


@Preview
@Composable
fun a_ButtonLarge(
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    title: String = "Next",
    onButtonClick: () -> Unit = {}
) =
    Text(
        text = title, style = mccTypography.bodyLarge,
        textAlign = TextAlign.Center, modifier = Modifier
            .padding(bottom = 40.sdp)
            .then(modifier)
            .shadow(10.sdp, shape = RoundedCornerShape(6.sdp), spotColor = colorFadeSecondaryLight)
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = if (isEnabled) listOf(
                        colorGradientLightBlue,
                        colorGradientGreyBlue
                    ) else listOf(
                        colorWhite,
                        colorAccentGrey,
                        colorGrey
                    )
                ), shape = RoundedCornerShape(6.sdp)
            )
            .padding(vertical = 10.sdp)
            .clickable {
                if (isEnabled) onButtonClick.invoke()
            },
        color = if (isEnabled) colorWhite else colorSecondaryGrey
    )


@Preview
@Composable
fun a_ButtonSmall(
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    title: String = "Next",
    onButtonClick: () -> Unit = {}
) = Text(
    text = title, style = mccTypography.displayMedium,
    textAlign = TextAlign.Center, modifier = Modifier
        .padding(bottom = 40.sdp)
        .then(modifier)
        .shadow(10.sdp, shape = RoundedCornerShape(6.sdp), spotColor = colorFadeSecondaryLight)
        .wrapContentWidth()
        .background(
            brush = Brush.linearGradient(
                colors = if (isEnabled) listOf(
                    colorGradientLightBlue,
                    colorGradientGreyBlue
                ) else listOf(
                    colorWhite,
                    colorAccentGrey,
                    colorGrey
                )
            ), shape = RoundedCornerShape(6.sdp)
        )
        .padding(vertical = 10.sdp, horizontal = 40.sdp)
        .clickable {
            if (isEnabled) onButtonClick.invoke()
        },
    color = if (isEnabled) colorWhite else colorSecondaryGrey
)