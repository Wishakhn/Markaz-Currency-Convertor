package com.markaz.currencyconvertor.presentation.welcome.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextLableLarge
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextSubtitleLarge
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextTitleLarge
import com.markaz.currencyconvertor.ui.theme.authLoginNote
import com.markaz.currencyconvertor.ui.theme.colorWhite
import com.markaz.currencyconvertor.ui.theme.splashSubtitle
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun LableWelcome(modifier: Modifier = Modifier) = a_TextLableLarge(
    text = authLoginNote,
    modifier = Modifier
        .padding(horizontal = 15.sdp, vertical = 10.sdp)
        .then(modifier)
        .fillMaxWidth()
        .alpha(0.7f)
)


@Preview
@Composable
fun SubtitleWelcome(modifier: Modifier = Modifier) = a_TextTitleLarge(
    text = "MARKAZ \nCURRENCY CONVERTER",
    modifier = Modifier
        .padding(top = 15.sdp)
        .padding(horizontal = 15.sdp, vertical = 2.sdp)
        .then(modifier)
        .fillMaxWidth(),
    align = TextAlign.Center,
)

@Preview
@Composable
fun NoteWelcome(modifier: Modifier = Modifier) = a_TextSubtitleLarge(
    text = splashSubtitle,
    modifier = Modifier
        .padding(horizontal = 15.sdp, vertical = 2.sdp)
        .then(modifier)
        .fillMaxWidth()
        .alpha(0.5f),
    color = colorWhite
)