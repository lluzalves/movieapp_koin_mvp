package com.app.daniel.app.movieapp.base

import android.content.Context
import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var applicationContext: Context

    override fun onDetach() {
        compositeDisposable.clear()
    }
}