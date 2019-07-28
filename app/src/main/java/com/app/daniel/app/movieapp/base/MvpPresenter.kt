package com.app.daniel.app.movieapp.base

interface MvpPresenter<V : MvpView>{
    val view : V
    fun onDetach()
}