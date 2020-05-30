package com.app.daniel.app.movieapp.di

import androidx.work.WorkManager
import com.app.daniel.app.data.repository.MovieRepositoryImpl
import com.app.daniel.app.domain.repository.MoviesRepository
import com.app.daniel.app.domain.usecases.OnMoviesRequestUseCase
import com.app.daniel.app.movieapp.base.SharedPreferences
import com.app.daniel.app.movieapp.movies.MoviesPresenter
import com.app.daniel.app.movieapp.movies.MoviesContract
import com.app.daniel.app.movieapp.movies.details.MovieDetailsContract
import com.app.daniel.app.movieapp.movies.details.MovieDetailsPresenter
import com.app.daniel.app.movieapp.splash.SplashContract
import com.app.daniel.app.movieapp.splash.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module


val applicationModule = module {
    single { WorkManager.getInstance(androidContext().applicationContext) }
    factory<SplashContract.SplashPresenter> { (view: SplashContract.SplashView) ->
        SplashPresenter(
            view
        )
    }
    factory<MoviesContract.MoviePresenter> { (view: MoviesContract.MoviesView) ->
        MoviesPresenter(
            view
        )
    }
    factory<MovieDetailsContract.MovieDetailsPresenter> { (view: MovieDetailsContract.MovieDetailsView) ->
        MovieDetailsPresenter(
            view
        )
    }
    single { SharedPreferences(androidContext().applicationContext) }
}

val domainModule = module {
    factory { MovieRepositoryImpl(get()) as MoviesRepository }
    factory { OnMoviesRequestUseCase(get()) }
}

