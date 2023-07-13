package com.markaz.currencyconvertor.presentation.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.markaz.currencyconvertor.ui.theme.colorGradientBlueGrey
import com.markaz.currencyconvertor.ui.theme.colorGradientGrey
import com.markaz.currencyconvertor.ui.theme.colorGradientPink
import com.markaz.currencyconvertor.ui.theme.colorGradientPurple
import com.markaz.currencyconvertor.ui.theme.colorGradientSky
import com.markaz.currencyconvertor.ui.theme.colorGradientViolet
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp


@Preview
@Composable
fun SparklingView(modifier: Modifier = Modifier) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight().then(modifier),
    elevation = CardDefaults.cardElevation(10.sdp),
    colors = CardDefaults.cardColors(contentColor = colorWhite),
    shape = RoundedCornerShape(15.sdp)
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.sdp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorGradientSky,
                        colorGradientViolet,
                        colorGradientPink,
                        colorGradientPurple,
                        colorGradientGrey,
                        colorGradientBlueGrey
                    ),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .padding(15.sdp)
    ) {
        val (label, rate, logo, icon, ratePoint) = createRefs()
        LabelDashboardCard(
            modifier = Modifier.constrainAs(label) {
                linkTo(logo.end, parent.end)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            })
        RatesDashboardCard(modifier = Modifier
            .constrainAs(rate) {
                linkTo(logo.end, parent.end)
                top.linkTo(label.bottom)
                width = Dimension.fillToConstraints
            })

        LogoCard(
            modifier = Modifier
                .constrainAs(logo) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })
        ArrowCard(modifier = Modifier
            .constrainAs(icon) {
                start.linkTo(logo.end)
                top.linkTo(rate.bottom)
            })
        PercentageCard(modifier = Modifier
            .constrainAs(ratePoint) {
                start.linkTo(icon.end)
                top.linkTo(rate.bottom)
            })


    }
}