package com.markaz.currencyconvertor.presentation.splash

import com.markaz.currencyconvertor.utils.interfaces.IBaseEffects
import com.markaz.currencyconvertor.utils.interfaces.IBaseEvents
import com.markaz.currencyconvertor.utils.interfaces.IBaseStateModel
import com.markaz.currencyconvertor.utils.network.NetworkStatus

sealed class SplashEvent : IBaseEvents {
    object NavigateToNext : SplashEvent()
}

sealed class SplashEffect : IBaseEffects {
    object NavigateToNext : SplashEffect()
}

data class SplashStateModel(
    val isInternetConnected: NetworkStatus = NetworkStatus.Unavailable
) : IBaseStateModel
