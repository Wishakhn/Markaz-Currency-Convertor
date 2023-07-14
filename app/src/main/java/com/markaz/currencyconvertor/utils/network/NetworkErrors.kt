package com.markaz.currencyconvertor.utils.network

sealed class NetworkErrors {
    object NoInternet : NetworkErrors()
    object RequestTimedOut : NetworkErrors()
    object BadGateway : NetworkErrors()
    object NotFound : NetworkErrors()
    object Forbidden : NetworkErrors()
    object SessionExpire : NetworkErrors()
    object InternalServerError : NetworkErrors()
    open class UnknownError : NetworkErrors()
}
