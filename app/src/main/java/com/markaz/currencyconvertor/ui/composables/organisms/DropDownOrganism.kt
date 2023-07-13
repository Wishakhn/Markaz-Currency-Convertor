package com.markaz.currencyconvertor.ui.composables.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.markaz.currencyconvertor.domain.models.CurrencyModel
import com.markaz.currencyconvertor.ui.composables.atoms.HintText
import com.markaz.currencyconvertor.ui.composables.atoms.a_TextDisplaySmall
import com.markaz.currencyconvertor.ui.composables.molecules.TextWithIcon
import com.markaz.currencyconvertor.ui.theme.colorSecondaryTeal
import ir.kaaveh.sdpcompose.sdp

@Preview
@Composable
fun DropDownCurrency(
    selectedCurrency: String = "CED",
    modifier: Modifier = Modifier,
    currencyItems: CurrencyModel? = null,
    onItemClick: (currency: String) -> Unit = {}
) = Column(
    modifier = Modifier
        .then(modifier)
) {
    a_TextDisplaySmall(text = "Select Currency", modifier = Modifier.padding(10.sdp, 10.sdp, 3.dp, 5.sdp), color = colorSecondaryTeal)
    Column(
        modifier = Modifier
            .padding(horizontal = 10.sdp, vertical = 15.sdp)
    ) {
        val dropDown = rememberSaveable {
            mutableStateOf(false)
        }
        TextWithIcon(selectedCurrency, modifier = Modifier.padding(vertical =  10.sdp, horizontal = 10.sdp), onIconSelected = {
            dropDown.value = dropDown.value.not()
        })

        if (dropDown.value && currencyItems?.currencies?.isNotEmpty() == true) {
            LazyColumn(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 10.sdp)
                    .height(150.sdp)
            ) {
                items(currencyItems?.currencies ?: listOf()) { item ->
                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .width(50.sdp)
                            .padding(bottom = 3.sdp)
                    ) {
                        HintText(
                            text = item.currencyCode, modifier = Modifier
                                .wrapContentSize()
                                .align(Alignment.Center)
                                .clickable {
                                    onItemClick.invoke(item.currencyCode)
                                }
                        )
                    }
                }
            }
        }
    }
}


