package com.app.daniel.app.movieapp.movies.details


import com.app.daniel.app.domain.usecases.OnMoviesRequestUseCase
import com.app.daniel.app.movieapp.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieDetailsPresenter constructor(override val view: MovieDetailsContract.MovieDetailsView) :
    BasePresenter<MovieDetailsContract.MovieDetailsView>(), MovieDetailsContract.MovieDetailsPresenter, KoinComponent {
    private val movieUseCase: OnMoviesRequestUseCase  by inject()

    override fun fetchMovieDetails(id:String) {
        view.onLoadingState()
        compositeDisposable.addAll(movieUseCase.onRequestedMovieDetails(id)
            .subscribeBy(
                onSuccess = { movie ->
                    view.getMovie(movie)
                    view.onCompleteState()
                },
                onError = { error ->
                    view.onError(error.localizedMessage)
                    view.onErrorState()
                }
            )
        )
    }

}