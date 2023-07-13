package com.markaz.currencyconvertor.presentation.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.markaz.currencyconvertor.presentation.dashboard.ConnversionOptions
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun OptionSquare(
    modifier: Modifier = Modifier,
    option: ConnversionOptions = ConnversionOptions.SingleConversion
) = Card(
    modifier = Modifier
        .wrapContentSize()
        .then(modifier),
    elevation = CardDefaults.cardElevation(10.sdp),
    colors = CardDefaults.cardColors(contentColor = colorWhite),
    shape = RoundedCornerShape(15.sdp)
) {
    ConstraintLayout(
        modifier = Modifier
            .height(130.sdp)
            .background(
                brush = Brush.linearGradient(
                    colors = getGradient(option),
                    start = Offset(45f, 45f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .border(
                width = 1.sdp, shape = RoundedCornerShape(15.sdp), brush = Brush.verticalGradient(
                    colors = getGradientStroke(option)
                )
            )
            .padding(7.sdp)
    ) {
        val (icon, title, type, click) = createRefs()

        OptIcon(modifier = Modifier
            .constrainAs(icon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
        option = option)

        OptTitleText(modifier = Modifier
            .constrainAs(title) {
                top.linkTo(parent.top)
                linkTo(icon.end, parent.end)
            },
        option = option)

        OptTypeText(modifier = Modifier
            .constrainAs(type) {
                linkTo(icon.end, parent.end)
                top.linkTo(title.bottom)
            },
            option = option)


        OptClickText(modifier = Modifier
            .constrainAs(click) {
                linkTo(parent.start, parent.end)
                top.linkTo(type.bottom)
                bottom.linkTo(parent.bottom)
            },
            option = option)

    }
}


