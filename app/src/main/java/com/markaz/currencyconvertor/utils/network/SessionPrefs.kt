package com.adopte.unelivraison.network.base


interface SessionPrefs {
    fun saveUser(user: User)
    fun getUser(): User?
    fun clearSession()
}