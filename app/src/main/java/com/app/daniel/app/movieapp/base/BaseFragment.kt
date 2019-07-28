package com.app.daniel.app.movieapp.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<P : MvpPresenter<*>> : Fragment(), MvpView {

    abstract val presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCompleted() {

    }

    override fun onError(errorMessage: String) {
        view?.let { Snackbar.make(it, errorMessage, Snackbar.LENGTH_LONG).show() }
    }

    override fun onError(throwable: Throwable) {
        view?.let { Snackbar.make(it, throwable.localizedMessage, Snackbar.LENGTH_LONG).show() }
    }
}