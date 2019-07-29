package com.app.daniel.app.movieapp.movies.details

import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.base.BaseMovieView
import com.app.daniel.app.movieapp.base.MvpPresenter

interface MovieDetailsContract {

    interface MovieDetailsView : BaseMovieView {
        fun getMovie(movie: Movie)
    }

    interface MovieDetailsPresenter : MvpPresenter<MovieDetailsView> {
        fun fetchMovieDetails(id:String)
    }
}