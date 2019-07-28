package com.app.daniel.app.movieapp.movies

import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.base.BaseMovieView
import com.app.daniel.app.movieapp.base.MvpPresenter

interface MoviesContract {

    interface MoviesView : BaseMovieView {
        fun onLayoutItemsChangeOrientation()
        fun getMovies(movies: List<Movie>)
    }

    interface MoviePresenter : MvpPresenter<MoviesView> {
        fun fetchPopularMovies(page: Int)
    }
}