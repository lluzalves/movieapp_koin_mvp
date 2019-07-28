package com.app.daniel.app.movieapp.base

import android.content.Context

interface MvpPresenter<V : MvpView>{
    val view : V
    fun onDetach()
    fun checkConnectivity(applicationContext: Context)
    fun onConnectivity(isConnected : Boolean) : Boolean
}