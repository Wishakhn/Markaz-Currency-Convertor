package com.markaz.currencyconvertor.presentation.splash

import com.markaz.currencyconvertor.utils.base.BaseViewModel
import com.markaz.currencyconvertor.utils.extenssions.thenNoAction
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.Intent
import com.markaz.currencyconvertor.utils.network.NetworkStatus
import kotlinx.coroutines.flow.Flow

class SplashViewModel : BaseViewModel<SplashEvent, SplashStateModel, SplashEffect>() {
    override fun createInitialState(): SplashStateModel =
        SplashStateModel(isInternetConnected = NetworkStatus.Unavailable)

    override fun handleStateEvents(
        event: SplashEvent,
        effect: IEffect<SplashEffect>
    ): Flow<Intent<SplashStateModel>> = when (event) {
        is SplashEvent.NavigateToNext -> effect.send(SplashEffect.NavigateToNext).thenNoAction()
    }

}