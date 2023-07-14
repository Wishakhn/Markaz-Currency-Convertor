package com.markaz.currencyconvertor.presentation.converter.multiconverter.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.markaz.currencyconvertor.presentation.converter.CurrencyViewModel
import com.markaz.currencyconvertor.ui.composables.organisms.DropDownCurrency
import com.markaz.currencyconvertor.ui.composables.organisms.TextFieldOrganisms
import com.markaz.currencyconvertor.ui.theme.colorWhite
import com.markaz.currencyconvertor.utils.extenssions.collectAsState
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.getViewModel

@Preview
@Composable
fun MultiCurrencyScreen() = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(color = colorWhite)
        .padding(vertical = 30.sdp, horizontal = 15.sdp)
) {
    val (title, dropDown, currencyList, amount, button) = createRefs()

    val viewModel: CurrencyViewModel = getViewModel()
    val processor = viewModel.getStateProcessor()
    val currencyResponse by processor.collectAsState { it.currencyResponse }
    val exchangeResponse = processor.collectAsState { it.exchangerateResponse }
    val amountCurrecny = processor.collectAsState { it.amount }
    val selectedCurrecny = processor.collectAsState { it.selectedCurrency }
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
        text = "",
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


    ExhcangedCurrencyList(
        modifier = Modifier
            .padding(start = 0.sdp, end = 20.sdp, top = 20.sdp, bottom = 20.sdp)
            .constrainAs(currencyList) {
                linkTo(amount.start, parent.end)
                top.linkTo(button.bottom)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            }, processor
    )
}