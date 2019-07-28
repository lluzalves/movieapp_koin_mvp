package com.app.daniel.app.movieapp.splash

import com.app.daniel.app.movieapp.base.MvpPresenter
import com.app.daniel.app.movieapp.base.MvpView

interface SplashContract {

    interface SplashView : MvpView {
        fun startAnimation()
    }

    interface SplashPresenter : MvpPresenter<SplashView>
}