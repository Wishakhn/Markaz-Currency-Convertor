package com.markaz.currencyconvertor.presentation.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.markaz.currencyconvertor.navigation.MccNavGraph
import com.markaz.currencyconvertor.navigation.MccTransitions
import com.markaz.currencyconvertor.navigation.destinations.DashboardDestinations
import com.markaz.currencyconvertor.presentation.dashboard.ConnversionOptions
import com.markaz.currencyconvertor.presentation.dashboard.DashboardEvent
import com.markaz.currencyconvertor.presentation.dashboard.DashboardViewModel
import com.markaz.currencyconvertor.ui.theme.colorWhite
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.getViewModel

@Composable
@MccNavGraph(start = true)
@Destination(style = MccTransitions::class)
fun DashboardScreen(
    viewModel: DashboardViewModel = getViewModel(),
    destinationsNavigator: DestinationsNavigator
) =
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorWhite)
            .padding(vertical = 30.sdp, horizontal = 15.sdp)
    ) {
        val processor = viewModel.getStateProcessor()

        val (title, card, ccSignle, ccMultiple, learnTrade) = createRefs()
        TitleDashboardCard(modifier = Modifier.constrainAs(title) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })

        SparklingView(modifier = Modifier
            .padding(top = 20.sdp)
            .constrainAs(card) {
                linkTo(parent.start, parent.end)
                top.linkTo(title.bottom)
            })

        OptionSquare(
            modifier = Modifier
                .padding(top = 20.sdp, end = 5.sdp)
                .constrainAs(ccSignle) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(card.bottom)
                    width = Dimension.fillToConstraints
                }
                .clickable {
                    processor.sendEvent(DashboardEvent.NavigateToSingle)
                },
        )
        OptionSquare(
            modifier = Modifier
                .padding(top = 20.sdp)
                .constrainAs(ccMultiple) {
                    linkTo(parent.start, parent.end)
                    top.linkTo(ccSignle.bottom)
                    width = Dimension.fillToConstraints
                }
                .clickable {
                    processor.sendEvent(DashboardEvent.NavigateToMulti)
                },
            option = ConnversionOptions.MultiConversion
        )

        DashboardDestinations(viewModel = viewModel, destinationsNavigator)
    }