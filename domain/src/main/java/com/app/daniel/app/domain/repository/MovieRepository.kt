package com.app.daniel.app.domain.repository

import com.app.daniel.app.domain.dto.Movie
import io.reactivex.Single

interface MoviesRepository : Repository<Movie> {
    fun fetchPopularMovies(requestedEndpointPage:Int) : Single<List<Movie>>
    fun fetchUpcomingMovies(requestedEndpointPage:Int) : Single<List<Movie>>
    fun fetchTopRatedMovies(requestedEndpointPage:Int) : Single<List<Movie>>

}