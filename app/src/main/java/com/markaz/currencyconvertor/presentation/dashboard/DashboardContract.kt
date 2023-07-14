package com.markaz.currencyconvertor.presentation.dashboard

import com.markaz.currencyconvertor.utils.interfaces.IBaseEffects
import com.markaz.currencyconvertor.utils.interfaces.IBaseEvents
import com.markaz.currencyconvertor.utils.interfaces.IBaseStateModel
import com.markaz.currencyconvertor.utils.network.NetworkStatus


sealed class DashboardEvent : IBaseEvents {
    object NavigateToSingle : DashboardEvent()
    object NavigateToMulti : DashboardEvent()
}

sealed class DashboardEffect : IBaseEffects {
    object NavigateToSingle : DashboardEffect()
    object NavigateToMulti : DashboardEffect()
}

data class DashboardStateModel(
    val isInternetConnected: NetworkStatus = NetworkStatus.Unavailable
) : IBaseStateModel


sealed class ConnversionOptions {
    object SingleConversion : ConnversionOptions()
    object MultiConversion : ConnversionOptions()
}
