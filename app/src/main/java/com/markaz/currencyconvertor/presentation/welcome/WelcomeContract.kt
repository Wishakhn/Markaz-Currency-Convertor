package com.markaz.currencyconvertor.presentation.welcome

import com.markaz.currencyconvertor.utils.interfaces.IBaseEffects
import com.markaz.currencyconvertor.utils.interfaces.IBaseEvents
import com.markaz.currencyconvertor.utils.interfaces.IBaseStateModel
import com.markaz.currencyconvertor.utils.network.NetworkStatus

sealed class WelcomeEvent : IBaseEvents {
    object NavigateToNext : WelcomeEvent()
}

sealed class WelcomeEffect : IBaseEffects {
    object NavigateToNext : WelcomeEffect()
}

data class WelcomeStateModel(
    val isInternetConnected: NetworkStatus = NetworkStatus.Unavailable
) : IBaseStateModel