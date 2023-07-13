package com.markaz.currencyconvertor.presentation.multiconverter.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.markaz.currencyconvertor.ui.composables.organisms.DropDownCurrency
import com.markaz.currencyconvertor.ui.composables.organisms.TextFieldOrganisms
import com.markaz.currencyconvertor.ui.theme.colorWhite
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun MultiCurrencyScreen() = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(color = colorWhite)
        .padding(vertical = 30.sdp, horizontal = 15.sdp)
) {
    val (title, dropDown, currencyList, amount, button) = createRefs()
    DropDownCurrency(
        selectedCurrency = "USD",
        currencyItems = null,
        modifier = Modifier.constrainAs(dropDown) {
            linkTo(amount.end, parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(amount.bottom)
        }
    ) {
      //  viewModel.setEvent(CCEvent.UpdateSelectedCurrency(it))
    }
    TextFieldOrganisms(
        text =  "",
        modifier = Modifier
            .padding(start = 0.sdp)
            .constrainAs(amount) {
                linkTo(parent.start, dropDown.start)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
        onValueChange = {
       //     viewModel.setEvent(CCEvent.EnableButton(it, it.isNotBlank()))
        })
}