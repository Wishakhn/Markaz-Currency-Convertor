package com.markaz.currencyconvertor.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.markaz.currencyconvertor.presentation.splash.SplashViewModel
import com.markaz.currencyconvertor.presentation.welcome.WelcomeViewModel
import com.markaz.currencyconvertor.presentation.welcome.composables.WelcomeScreen
import com.markaz.currencyconvertor.ui.theme.MCCTheme

class WelcomeActivity : ComponentActivity() {
    private val viewModel: WelcomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MCCTheme {
                WelcomeScreen(viewModel)
            }
        }
    }
}
