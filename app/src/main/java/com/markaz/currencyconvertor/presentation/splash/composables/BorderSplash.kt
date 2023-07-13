package com.markaz.currencyconvertor.presentation.splash.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.R
import ir.kaaveh.sdpcompose.sdp


@Preview
@Composable
fun BorderSplash(modifier: Modifier = Modifier) = Image(painter = painterResource(id = R.drawable.ic_border),
    contentDescription = "",
    contentScale = ContentScale.FillBounds,
    modifier = Modifier
        .padding(horizontal = 20.sdp)
        .fillMaxWidth()
        .height(250.sdp).then(modifier)
       )