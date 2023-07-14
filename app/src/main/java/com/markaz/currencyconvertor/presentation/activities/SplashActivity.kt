package com.markaz.currencyconvertor.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.markaz.currencyconvertor.presentation.splash.SplashEffect
import com.markaz.currencyconvertor.presentation.splash.SplashEvent
import com.markaz.currencyconvertor.presentation.splash.SplashViewModel
import com.markaz.currencyconvertor.presentation.splash.composables.SplashScreen
import com.markaz.currencyconvertor.ui.theme.MCCTheme
import com.markaz.currencyconvertor.utils.extenssions.onCreated
import com.markaz.currencyconvertor.utils.network.ConnectivityObserver
import com.markaz.currencyconvertor.utils.network.NetworkConnectivityObserver
import kotlinx.coroutines.delay

private lateinit var connectivityObserver: ConnectivityObserver

class SplashActivity : ComponentActivity() {
    val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { false }
        setContent {
            MCCTheme {
                SplashScreen()
            }
        }

        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        lifecycleScope.launchWhenResumed {
            delay(4000)
            connectivityObserver.observe().collect { status ->
                viewModel.setEvent(SplashEvent.NavigateToNext)
            }
        }
        onCreated(viewModel::getStateProcessor, onEffect = ::trigger)
    }

    private fun trigger(effect: SplashEffect) {
        when (effect) {
            is SplashEffect.NavigateToNext -> {
                val intent = Intent(this@SplashActivity, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
