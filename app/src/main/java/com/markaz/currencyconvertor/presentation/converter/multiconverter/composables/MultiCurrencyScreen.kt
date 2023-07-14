package com.markaz.currencyconvertor.presentation.converter.multiconverter.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.domain.models.ExchangeRateModel
import com.markaz.currencyconvertor.navigation.MccNavGraph
import com.markaz.currencyconvertor.navigation.MccTransitions
import com.markaz.currencyconvertor.presentation.converter.CCEvent
import com.markaz.currencyconvertor.presentation.converter.CurrencyViewModel
import com.markaz.currencyconvertor.ui.composables.atoms.a_ButtonLarge
import com.markaz.currencyconvertor.ui.composables.organisms.DropDownCurrency
import com.markaz.currencyconvertor.ui.composables.organisms.TextFieldOrganisms
import com.markaz.currencyconvertor.ui.theme.colorWhite
import com.markaz.currencyconvertor.utils.extenssions.collectAsState
import com.markaz.currencyconvertor.utils.network.ApiError
import com.ramcosta.composedestinations.annotation.Destination
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.getViewModel

@Preview
@Composable
@MccNavGraph(start = false)
@Destination(style = MccTransitions::class)
fun MultiCurrencyScreen() = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(color = colorWhite)
        .padding(vertical = 30.sdp, horizontal = 15.sdp)
) {
    val (title, dropDown, currencyList, amount, button, progress) = createRefs()

    val viewModel: CurrencyViewModel = getViewModel()
    val processor = viewModel.getStateProcessor()
    val currencyResponse by processor.collectAsState { it.currencyResponse }
    val exchangeResponse = processor.collectAsState { it.exchangerateResponse }
    val amountCurrecny = processor.collectAsState { it.amount }
    val selectedCurrecny = processor.collectAsState { it.selectedCurrency }
    val isButtonEnabled = processor.collectAsState { it.enableButton }
    val isLoading = processor.collectAsState { it.isLoading }

    viewModel.setEvent(CCEvent.RequestExchangeRates)
    viewModel.setEvent(CCEvent.RequestCurrencyRates)
    DropDownCurrency(
        selectedCurrency = selectedCurrecny.value,
        currencyItems = currencyResponse,
        modifier = Modifier.constrainAs(dropDown) {
            linkTo(amount.end, parent.end)
            top.linkTo(parent.top)
        }
    ) {
        viewModel.setEvent(CCEvent.UpdateSelectedCurrency(it))
    }
    TextFieldOrganisms(
        text = amountCurrecny.value ?: "",
        modifier = Modifier
            .padding(start = 0.sdp)
            .constrainAs(amount) {
                linkTo(parent.start, dropDown.start)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
        onValueChange = {
            viewModel.setEvent(CCEvent.EnableButton(it, it.isNotBlank()))
        })


    ExhcangedCurrencyList(
        modifier = Modifier
            .padding(start = 0.sdp, end = 20.sdp, top = 20.sdp, bottom = 20.sdp)
            .wrapContentHeight()
            .constrainAs(currencyList) {
                linkTo(parent.start, parent.end)
                top.linkTo(amount.bottom)
                bottom.linkTo(button.top)
                height = Dimension.fillToConstraints
            }, processor
    )
    if (isLoading.value && currencyResponse == null) {
        Column(modifier = Modifier.constrainAs(progress) {
            linkTo(parent.start, parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_icon
                ), contentDescription = ""
            )
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }

    a_ButtonLarge(isEnabled = isButtonEnabled.value, modifier = Modifier.constrainAs(button) {
        linkTo(amount.start, parent.end)
        bottom.linkTo(parent.bottom)
    }, onButtonClick = {
        viewModel.setEvent(
            CCEvent.ConvertCurrencyRate(
                amount = amountCurrecny.value,
                selectedCurrency = selectedCurrecny.value,
                exchangeRateResponse = exchangeResponse.value ?: ExchangeRateModel(
                    "",
                    emptyList(),
                    error = ""
                )
            )
        )
    })
}