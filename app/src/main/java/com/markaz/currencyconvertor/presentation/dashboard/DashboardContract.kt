package com.markaz.currencyconvertor.presentation.dashboard

class DashboardContract {
}


sealed class ConnversionOptions {
    object SingleConversion : ConnversionOptions()
    object MultiConversion : ConnversionOptions()
}
