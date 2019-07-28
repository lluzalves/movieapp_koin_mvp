package com.app.daniel.app.movieapp.di

import androidx.work.WorkManager
import com.app.daniel.app.domain.usecases.OnMoviesRequestUseCase
import com.app.daniel.app.movieapp.movies.MoviePresenter
import com.app.daniel.app.movieapp.movies.MoviesContract
import com.app.daniel.app.movieapp.splash.SplashContract
import com.app.daniel.app.movieapp.splash.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val applicationModule = module(override = true) {
    single { WorkManager.getInstance(androidContext().applicationContext) }
    factory<SplashContract.SplashPresenter> { (view: SplashContract.SplashView) -> SplashPresenter(view) }
    factory<MoviesContract.MoviePresenter> { (view: MoviesContract.MoviesView) -> MoviePresenter(view) }

}

val domainModule = module(override = true) {
    factory { OnMoviesRequestUseCase() }
}
