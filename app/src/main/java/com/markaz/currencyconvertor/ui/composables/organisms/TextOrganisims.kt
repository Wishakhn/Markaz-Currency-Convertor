package com.markaz.currencyconvertor.ui.composables.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextDisplaySmall
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextField
import com.markaz.currencyconvertor.ui.theme.colorPrimaryPeach
import com.markaz.currencyconvertor.ui.theme.colorSecondaryTeal
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun TextFieldOrganisms(
    title: String = "Enter the conversion amount.",
    text: String = "393993",
    modifier: Modifier = Modifier,
    onValueChange: (text: String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .then(modifier)
    ) {
        a_TextDisplaySmall(
            text = title,
            modifier = Modifier.padding(bottom = 3.sdp),
            color = colorSecondaryTeal
        )
        a_TextField(
            value = text,
            label = "Amount",
            onValueChanged = {
                onValueChange.invoke(it)
            },
            modifier = Modifier
                .shadow(
                    elevation = 20.sdp,
                    RoundedCornerShape( 8.sdp),
                    spotColor = colorPrimaryPeach
                )
                .background(colorWhite, RoundedCornerShape( 8.sdp))
                .padding(8.sdp)
        )
    }
}