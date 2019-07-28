package com.app.daniel.app.data.services

import com.app.daniel.app.commons.Constants
import com.app.daniel.app.commons.Constants.MovieApi.API_VERSION
import com.app.daniel.app.commons.Constants.MovieApi.MOVIE
import com.app.daniel.app.commons.Constants.MovieApi.SEARCH

class MovieApiUrls {
    object Params {
        const val MOVIE_ID = "movie_id"
        const val API_KEY = "api_key"
        const val POPULAR = "popular"
    }

    object Urls {
        const val UPCOMING_MOVIES = API_VERSION.plus(SEARCH).plus(MOVIE)
        const val MOVIE_DETAILS = Constants.MovieApi.API_VERSION.plus(MOVIE).plus("/{Params.MOVIE_ID}")
        const val POPULAR_MOVIES = Constants.MovieApi.API_VERSION.plus(MOVIE).plus("/popular")
    }
}
