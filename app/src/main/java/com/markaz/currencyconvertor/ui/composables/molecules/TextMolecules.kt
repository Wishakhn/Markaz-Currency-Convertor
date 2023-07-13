package com.markaz.currencyconvertor.ui.composables.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextDisplayMedium
import com.markaz.currencyconvertor.ui.theme.colorPrimaryPeach
import com.markaz.currencyconvertor.ui.theme.colorSecondaryPeach
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp

@Preview(showBackground = true)
@Composable
fun TextWithIcon(
    text: String = "AED",
    drawable: Int = R.drawable.ic_dropdown,
    modifier: Modifier = Modifier,
    onIconSelected: () -> Unit = {}
) =
    Row(
        modifier = Modifier
            .wrapContentSize()
            .shadow(
                elevation = 20.sdp,
                RoundedCornerShape(8.sdp),
                spotColor = colorPrimaryPeach
            )
            .background(colorWhite, RoundedCornerShape(8.sdp))

            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        a_TextDisplayMedium(
            text, Modifier
                .padding(end = 10.sdp)
        )
        Icon(
            painter = painterResource(id = drawable),
            contentDescription = "",
            modifier = Modifier
                .height(20.sdp)
                .width(20.sdp)
                .clickable {
                    onIconSelected.invoke()
                },
            tint = colorSecondaryPeach
        )
    }