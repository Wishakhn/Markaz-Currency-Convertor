package com.markaz.currencyconvertor.presentation.splash.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.ui.theme.colorPureWhite
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun AppIconCard (modifier: Modifier = Modifier) =     Card(
    modifier = Modifier
        .padding(top = 40.sdp)
        .width(130.sdp)
        .height(130.sdp)
        .padding(10.sdp).then(modifier)
        ,
    colors = CardDefaults.cardColors(contentColor = colorPureWhite),
    shape = RoundedCornerShape(15.sdp)
) {
    Image(
        painter = painterResource(id = R.drawable.ic_icon),
        contentDescription = "",
        modifier = Modifier.fillMaxSize()
    )
}