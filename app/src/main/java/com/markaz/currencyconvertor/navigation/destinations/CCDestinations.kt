package com.markaz.currencyconvertor.navigation.destinations

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.markaz.currencyconvertor.presentation.activities.MainActivity
import com.markaz.currencyconvertor.presentation.welcome.WelcomeEffect
import com.markaz.currencyconvertor.presentation.welcome.WelcomeViewModel
import com.markaz.currencyconvertor.utils.extenssions.onStateConsumed
import kotlinx.coroutines.launch

@Composable
fun WelcomeDestinations(viewModel: WelcomeViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val context = (LocalContext.current as? Activity)
    onStateConsumed(viewModel::getStateProcessor, onEffect = { effect ->
        when (effect) {
            WelcomeEffect.NavigateToNext -> {
                coroutineScope.launch {
                    context?.startActivity(Intent(context, MainActivity::class.java))
                    context?.finish()
                }
            }
        }
    }
    )
}