package com.markaz.currencyconvertor.presentation.splash.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.markaz.currencyconvertor.ui.theme.colorGradientBlackBlue
import com.markaz.currencyconvertor.ui.theme.colorGradientLightBlue

@Preview
@Composable
fun SplashScreen() = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    colorGradientLightBlue,
                    colorGradientBlackBlue
                ),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        )
) {
    val (icon, title, texture) = createRefs()

    BorderSplash(Modifier.constrainAs(texture) {
        linkTo(parent.start, parent.end)
        bottom.linkTo(parent.bottom)
    })

    AppIconCard(modifier = Modifier.constrainAs(icon) {
        linkTo(parent.start, parent.end)
        top.linkTo(parent.top)
    })

    LableSplash(Modifier.constrainAs(title) {
        linkTo(parent.start, parent.end)
        top.linkTo(icon.bottom)
    })
}