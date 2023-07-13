package com.markaz.currencyconvertor.ui.composables.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.ui.theme.colorPrimaryBlue
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun A_UserImage(
    resource: Int = R.drawable.ic_account,
    bitmap: ImageBitmap? = null,
    modifier: Modifier = Modifier,
    onImageUpload: () -> Unit = {}
) = Box(
    modifier = Modifier
        .then(modifier)
        .wrapContentSize(),
) {
    A_ImageVector(resource, bitmap)
}

@Composable
fun A_ImageVector(resource: Int = R.drawable.ic_account, bitmap: ImageBitmap?) =
    bitmap?.let { image ->
        Image(
            bitmap = image,
            contentDescription = "",
            modifier = Modifier
                .width(60.sdp)
                .height(60.sdp)
                .clip(RoundedCornerShape(30.sdp))
                .background(
                    color = colorWhite, shape = RoundedCornerShape(30.sdp)
                )
                .border(3.sdp, shape = RoundedCornerShape(30.sdp), color = colorPrimaryBlue)
                .padding(3.sdp)
        )
    } ?: Image(
        painter = painterResource(id = resource),
        contentDescription = "",
        modifier = Modifier
            .width(60.sdp)
            .height(60.sdp)
            .clip(RoundedCornerShape(30.sdp))
            .background(
                color = colorWhite, shape = RoundedCornerShape(30.sdp)
            )
            .border(3.sdp, shape = RoundedCornerShape(30.sdp), color = colorPrimaryBlue)
            .padding(3.sdp)
    )
