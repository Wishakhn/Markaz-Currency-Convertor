package com.markaz.currencyconvertor.presentation.dashboard

import com.markaz.currencyconvertor.utils.base.BaseViewModel
import com.markaz.currencyconvertor.utils.extenssions.thenNoAction
import com.markaz.currencyconvertor.utils.interfaces.IEffect
import com.markaz.currencyconvertor.utils.interfaces.Intent
import com.markaz.currencyconvertor.utils.network.NetworkStatus
import kotlinx.coroutines.flow.Flow

class DashboardViewModel() : BaseViewModel<DashboardEvent, DashboardStateModel, DashboardEffect>() {
    override fun createInitialState(): DashboardStateModel =
        DashboardStateModel(isInternetConnected = NetworkStatus.Unavailable)


    override fun handleStateEvents(
        event: DashboardEvent,
        effect: IEffect<DashboardEffect>
    ): Flow<Intent<DashboardStateModel>> = when (event) {
        is DashboardEvent.NavigateToSingle -> effect.send(DashboardEffect.NavigateToSingle)
            .thenNoAction()

        is DashboardEvent.NavigateToMulti -> effect.send(DashboardEffect.NavigateToMulti)
            .thenNoAction()
    }

}