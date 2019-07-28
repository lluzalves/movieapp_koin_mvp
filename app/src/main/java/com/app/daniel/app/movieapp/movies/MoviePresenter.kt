package com.app.daniel.app.movieapp.movies


import com.app.daniel.app.domain.usecases.MovieRequestType
import com.app.daniel.app.domain.usecases.OnMoviesRequestUseCase
import com.app.daniel.app.movieapp.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy
import org.koin.core.KoinComponent
import org.koin.core.inject

class MoviePresenter constructor(override val view: MoviesContract.MoviesView) :
    BasePresenter<MoviesContract.MoviesView>(), MoviesContract.MoviePresenter, KoinComponent {

    private val movieUseCase : OnMoviesRequestUseCase  by inject()
        override fun fetchPopularMovies(page: Int) {
            view.onLoadingState()
            compositeDisposable.addAll(movieUseCase.onRequest(page,MovieRequestType.POPULAR)
                .subscribeBy(
                    onSuccess = {movies ->
                        view.getMovies(movies)
                        view.onCompleteState()
                    },
                    onError = {error ->
                        view.onError(error.localizedMessage)
                        view.onErrorState()
                    }
                )
            )
    }

}