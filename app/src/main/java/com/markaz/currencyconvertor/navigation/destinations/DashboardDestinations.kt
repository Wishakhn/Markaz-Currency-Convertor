package com.markaz.currencyconvertor.navigation.destinations

import androidx.compose.runtime.Composable
import com.markaz.currencyconvertor.navigation.MCCRoutes
import com.markaz.currencyconvertor.presentation.dashboard.DashboardEffect
import com.markaz.currencyconvertor.presentation.dashboard.DashboardViewModel
import com.markaz.currencyconvertor.utils.extenssions.onStateConsumed
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun DashboardDestinations(viewModel: DashboardViewModel, navControler: DestinationsNavigator) {
    onStateConsumed(viewModel::getStateProcessor, onEffect = { effect ->
        when (effect) {
            is DashboardEffect.NavigateToSingle -> navControler.navigate(MCCRoutes.MCC_MULTI_CURRENCY)
            is DashboardEffect.NavigateToMulti -> navControler.navigate(MCCRoutes.MCC_MULTI_CURRENCY)
        }
    })
}