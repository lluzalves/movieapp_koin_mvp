package com.app.daniel.app.movieapp.base

interface BaseView {
    fun onLoading(loadingMessage : String)
    fun onCompleted()
    fun onError(throwable: Throwable)
    fun onError(errorMessage: String)
}