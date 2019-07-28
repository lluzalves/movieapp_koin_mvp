package com.app.daniel.app.movieapp.di

import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.app.daniel.app.data.fetch.FetchMoviesWorker
import com.app.daniel.app.movieapp.splash.SplashContract
import com.app.daniel.app.movieapp.splash.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val applicationModule = module(override = true) {

    fun createMovieWorkRequestTag() = "fetch_work"
    fun createFetchMovieWorkClassParam() = FetchMoviesWorker::class.java
    fun createMovieWorkRequest() = OneTimeWorkRequest.Builder(createFetchMovieWorkClassParam())
        .addTag(createMovieWorkRequestTag())
        .build()

    single { WorkManager.getInstance(androidContext().applicationContext) }
    factory { createMovieWorkRequest() }
    factory { createMovieWorkRequestTag() }
    factory<SplashContract.SplashPresenter> { (view: SplashContract.SplashView) -> SplashPresenter(view) }
}