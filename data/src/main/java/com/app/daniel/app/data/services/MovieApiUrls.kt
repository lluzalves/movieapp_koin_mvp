package com.app.daniel.app.data.services

import com.app.daniel.app.commons.Constants
import com.app.daniel.app.commons.Constants.MovieApi.API_VERSION
import com.app.daniel.app.commons.Constants.MovieApi.MOVIE
import com.app.daniel.app.commons.Constants.MovieApi.SEARCH
import com.app.daniel.app.data.services.MovieApiUrls.Params.API_KEY
import com.app.daniel.app.data.services.MovieApiUrls.Params.INCLUDE_ADULT_CONTENT
import com.app.daniel.app.data.services.MovieApiUrls.Params.MOVIE_ID
import com.app.daniel.app.data.services.MovieApiUrls.Params.POPULAR
import com.app.daniel.app.data.services.MovieApiUrls.Params.QUERY
import com.app.daniel.app.data.services.MovieApiUrls.Params.REQUESTED_PAGE

class MovieApiUrls {
    object Params {
        const val MOVIE_ID = "/{movie_id}"
        const val API_KEY = "api_key"
        const val POPULAR = "/popular"
        const val REQUESTED_PAGE = "page"
        const val QUERY = "query"
        const val INCLUDE_ADULT_CONTENT = "include_adult"
    }

    object Urls {
        fun buildSearchMovieRequestUrl(page: Int, query: String): Map<String, String> {
            val data: LinkedHashMap<String, String> = LinkedHashMap()
            data[API_KEY] = Constants.MovieApi.CLIENT_TOKEN
            data[REQUESTED_PAGE] = page.toString()
            data[QUERY] = query
            data[INCLUDE_ADULT_CONTENT] = false.toString()
            return data
        }

        fun buildPopularMovieRequestUrl(page: Int): Map<String, String> {
            val data: LinkedHashMap<String, String> = LinkedHashMap()
            data[API_KEY] = Constants.MovieApi.CLIENT_TOKEN
            data[REQUESTED_PAGE] = page.toString()
            data[INCLUDE_ADULT_CONTENT] = false.toString()
            return data
        }

        const val UPCOMING_MOVIES = API_VERSION.plus(SEARCH).plus(MOVIE)
        const val MOVIE_DETAILS = Constants.MovieApi.API_VERSION.plus(MOVIE).plus(MOVIE_ID)
        const val POPULAR_MOVIES = Constants.MovieApi.API_VERSION.plus(MOVIE).plus(POPULAR)
    }

}
