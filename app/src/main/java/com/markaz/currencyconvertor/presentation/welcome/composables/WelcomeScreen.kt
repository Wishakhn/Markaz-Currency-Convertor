package com.markaz.currencyconvertor.presentation.welcome.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.markaz.currencyconvertor.navigation.destinations.WelcomeDestinations
import com.markaz.currencyconvertor.presentation.welcome.WelcomeEvent
import com.markaz.currencyconvertor.presentation.welcome.WelcomeViewModel
import com.markaz.currencyconvertor.ui.composables.atoms.a_ButtonSmall
import com.markaz.currencyconvertor.ui.theme.colorGradientBlackBlue
import com.markaz.currencyconvertor.ui.theme.colorGradientLightBlue
import com.markaz.currencyconvertor.ui.theme.start
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.getViewModel

@Preview
@Composable
fun WelcomeScreen(viewModel: WelcomeViewModel = getViewModel()) = ConstraintLayout(
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
    val processor = viewModel.getStateProcessor()
    val (icon, title, subtitle, note, button, texture) = createRefs()
    BorderWelcome(Modifier.constrainAs(texture) {
        linkTo(parent.start, parent.end)
        bottom.linkTo(parent.bottom)
    })
    LableWelcome(
        Modifier
            .padding(top = 10.sdp)
            .constrainAs(title) {
                linkTo(parent.start, parent.end)
                top.linkTo(icon.bottom)
            })


    AppIconFadeCard(modifier = Modifier
        .padding(top = 35.sdp)
        .constrainAs(icon) {
            linkTo(parent.start, parent.end)
            top.linkTo(parent.top)
        })

    SubtitleWelcome(
        Modifier.constrainAs(subtitle) {
            linkTo(parent.start, parent.end)
            top.linkTo(title.bottom)
        }
    )

    NoteWelcome(Modifier.constrainAs(note) {
        linkTo(parent.start, parent.end)
        top.linkTo(subtitle.bottom)
    })

    a_ButtonSmall(
        isEnabled = true,
        Modifier
            .padding(bottom = 20.sdp)
            .constrainAs(button) {
                linkTo(parent.start, parent.end)
                top.linkTo(note.bottom)
                bottom.linkTo(parent.bottom)
            }
            .clickable {
                processor.sendEvent(WelcomeEvent.NavigateToNext)
            },
        title = start
    )
    WelcomeDestinations(viewModel = viewModel)
}