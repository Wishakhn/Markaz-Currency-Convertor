package com.adopte.unelivraison.network.base

data class User(
    val username: String?,
    val email: String?,
    val token: String?,
    val avatar: String?,
    val isLoggedIn: Boolean? = false
)