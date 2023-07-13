package com.markaz.currencyconvertor.presentation.welcome.composables

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.ui.theme.colorFadeSecondary
import com.markaz.currencyconvertor.ui.theme.colorFadeSecondaryLight
import com.markaz.currencyconvertor.ui.theme.colorGradientWhiteBlue
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun AppIconFadeCard(modifier: Modifier = Modifier) = Box(
    modifier = Modifier
        .then(modifier)
        .wrapContentSize()
        .shadow(
            10.sdp,
            RoundedCornerShape(12.sdp),
            ambientColor = colorGradientWhiteBlue,
            spotColor = colorGradientWhiteBlue
        )
        .background(colorFadeSecondaryLight, shape = RoundedCornerShape(12.sdp))
) {

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(R.drawable.gfiy_mobile, imageLoader),
        contentDescription = "",
        modifier = Modifier
            .background(colorFadeSecondaryLight, shape = RoundedCornerShape(12.sdp))
            .border(2.sdp, colorFadeSecondary, shape = RoundedCornerShape(12.sdp))
            .width(100.sdp)
            .height(100.sdp)
    )
}
