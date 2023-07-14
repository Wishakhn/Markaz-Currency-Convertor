package com.markaz.currencyconvertor.presentation.welcome

import com.markaz.currencyconvertor.utils.base.BaseViewModel
import com.markaz.currencyconvertor.utils.extenssions.thenNoAction
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.Intent
import com.markaz.currencyconvertor.utils.network.NetworkStatus
import kotlinx.coroutines.flow.Flow

class WelcomeViewModel : BaseViewModel<WelcomeEvent, WelcomeStateModel, WelcomeEffect>() {
    override fun createInitialState(): WelcomeStateModel =
        WelcomeStateModel(isInternetConnected = NetworkStatus.Unavailable)

    override fun handleStateEvents(
        event: WelcomeEvent,
        effect: IEffect<WelcomeEffect>
    ): Flow<Intent<WelcomeStateModel>> = when (event) {
        is WelcomeEvent.NavigateToNext -> effect.send(WelcomeEffect.NavigateToNext).thenNoAction()
    }

}