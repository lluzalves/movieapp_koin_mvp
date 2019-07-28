package com.app.daniel.app.data.services

import com.app.daniel.app.data.entity.MovieEntity
import com.app.daniel.app.data.services.MovieApiUrls.Params.API_KEY
import com.app.daniel.app.data.services.MovieApiUrls.Params.MOVIE_ID
import com.app.daniel.app.data.services.MovieApiUrls.Params.REQUESTED_PAGE
import com.app.daniel.app.data.services.MovieApiUrls.Urls.MOVIE_DETAILS
import com.app.daniel.app.data.services.MovieApiUrls.Urls.POPULAR_MOVIES
import com.app.daniel.app.data.services.MovieApiUrls.Urls.UPCOMING_MOVIES
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieService {

    @GET(UPCOMING_MOVIES)
    fun moviesQuery(@QueryMap options: Map<String, String>): Single<MovieResponse>

    @GET(MOVIE_DETAILS)
    fun movieDetails(
        @Path(MOVIE_ID) id: Int,
        @Query(API_KEY) api_key: String
    ): Single<MovieEntity>

    @GET("$POPULAR_MOVIES/{$REQUESTED_PAGE}")
    fun popularMovies(@Query(API_KEY) api_key: String,@Path(REQUESTED_PAGE) page:Int): Single<MovieResponse>

}