package com.app.daniel.app.movieapp.splash

import com.app.daniel.app.movieapp.base.BasePresenter
import org.koin.core.KoinComponent

class SplashPresenter constructor(override val view: SplashContract.SplashView) :
    BasePresenter<SplashContract.SplashView>(), SplashContract.SplashPresenter, KoinComponent