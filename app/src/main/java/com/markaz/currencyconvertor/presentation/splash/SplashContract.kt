package com.markaz.currencyconvertor.presentation.splash

import com.markaz.currencyconvertor.utils.interfaces.IBaseEffects
import com.markaz.currencyconvertor.utils.interfaces.IBaseEvents
import com.markaz.currencyconvertor.utils.interfaces.IBaseStateModel

sealed class DetailEffect : IBaseEffects {
    object NavigateBack : DetailEffect()
}


sealed class DetailEvent : IBaseEvents {
    object NavigateBack : DetailEvent()
    data class FetchRecipeDetails(val id: Int) : DetailEvent()
}

data class DetailStateModel(
    val idel: String = "",
    val loading: Boolean = false,
    val error: String? = null,
) : IBaseStateModel
