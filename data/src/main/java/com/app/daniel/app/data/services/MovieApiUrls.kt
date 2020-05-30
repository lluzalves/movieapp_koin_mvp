package com.app.daniel.app.data.services

import com.app.daniel.app.data.services.MovieApiUrls.Params.API_KEY
import com.app.daniel.app.data.services.MovieApiUrls.Params.INCLUDE_ADULT_CONTENT
import com.app.daniel.app.data.services.MovieApiUrls.Params.MOVIE
import com.app.daniel.app.data.services.MovieApiUrls.Params.MOVIE_ID_FOR_URL
import com.app.daniel.app.data.services.MovieApiUrls.Params.POPULAR
import com.app.daniel.app.data.services.MovieApiUrls.Params.REQUESTED_PAGE
import com.app.daniel.app.data.services.MovieApiUrls.Params.TOP_RATED
import com.app.daniel.app.data.services.MovieApiUrls.Params.UPCOMING

class MovieApiUrls {
    object MovieApi {
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_VERSION = "3"
        const val CLIENT_TOKEN = "b5f144e4118ef98b20e857f95ff3e437"
        const val PICTURE_PATH = "https://image.tmdb.org/t/p/w500/"

    }
    object Params {
        const val MOVIE_ID = "movie_id"
        const val MOVIE_ID_FOR_URL = "/{movie_id}"
        const val API_KEY = "api_key"
        const val POPULAR = "/popular"
        const val MOVIE = "/movie"
        const val TOP_RATED = "/top_rated"
        const val REQUESTED_PAGE = "page"
        const val UPCOMING = "/upcoming"
        const val QUERY = "query"
        const val INCLUDE_ADULT_CONTENT = "include_adult"
    }

    object Urls {
        fun buildMovieRequestUrl(page: Int?): Map<String, String> {
            val data: LinkedHashMap<String, String> = LinkedHashMap()
            data[API_KEY] = MovieApi.CLIENT_TOKEN
            data[REQUESTED_PAGE] = page.toString()
            data[INCLUDE_ADULT_CONTENT] = false.toString()
            return data
        }

        const val UPCOMING_MOVIES = MovieApi.API_VERSION.plus(MOVIE).plus(UPCOMING)
        const val MOVIE_DETAILS = MovieApi.API_VERSION.plus(MOVIE).plus(MOVIE_ID_FOR_URL)
        const val POPULAR_MOVIES = MovieApi.API_VERSION.plus(MOVIE).plus(POPULAR)
        const val TOP_RATED_MOVIES = MovieApi.API_VERSION.plus(MOVIE).plus(TOP_RATED)
    }

}
