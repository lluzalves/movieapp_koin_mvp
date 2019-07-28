package com.app.daniel.app.movieapp.base

interface MvpViewException {
    fun onAttachedException(): RuntimeException
    fun onConnectityFailure(): RuntimeException
}