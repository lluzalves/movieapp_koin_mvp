package com.app.daniel.app.movieapp.base

interface BaseMovieView : MvpView {
    fun onLoadingState()
    fun onCompleteState()
    fun onErrorState()
}