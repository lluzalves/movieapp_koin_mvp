package com.app.daniel.app.data.services

import com.app.daniel.app.data.entity.MovieEntity
import com.app.daniel.app.data.services.MovieApiUrls.Params.API_KEY
import com.app.daniel.app.data.services.MovieApiUrls.Params.MOVIE
import com.app.daniel.app.data.services.MovieApiUrls.Params.MOVIE_ID
import com.app.daniel.app.data.services.MovieApiUrls.Urls.MOVIE_DETAILS
import com.app.daniel.app.data.services.MovieApiUrls.Urls.POPULAR_MOVIES
import com.app.daniel.app.data.services.MovieApiUrls.Urls.TOP_RATED_MOVIES
import com.app.daniel.app.data.services.MovieApiUrls.Urls.UPCOMING_MOVIES
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieService {

    @GET(MOVIE_DETAILS)
    fun movieDetails(@Path(MOVIE_ID) movie_id: String, @Query(API_KEY) api_key: String): Single<MovieEntity>

    @GET(POPULAR_MOVIES)
    fun popularMovies(@QueryMap options: Map<String, String>): Single<MovieResponse>

    @GET(UPCOMING_MOVIES)
    fun upComingMovies(@QueryMap options: Map<String, String>): Single<MovieResponse>

    @GET(TOP_RATED_MOVIES)
    fun topRatedMovies(@QueryMap options: Map<String, String>): Single<MovieResponse>

}
