package com.markaz.currencyconvertor.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.markaz.currencyconvertor.presentation.NavGraphs
import com.markaz.currencyconvertor.presentation.dashboard.composables.DashboardScreen
import com.markaz.currencyconvertor.ui.theme.MCCTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MCCTheme {
                MccNavHost()
                // A surface container using the 'background' color from the them
            }
        }
    }


    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    @Preview(showBackground = true)
    @Composable
    fun MccNavHost(modifier: Modifier = Modifier) {
        val engine = rememberAnimatedNavHostEngine()
        val navController = engine.rememberNavController()

        DestinationsNavHost(
            navGraph = NavGraphs.mcc,
            engine = engine,
            navController = navController
        )
    }
}