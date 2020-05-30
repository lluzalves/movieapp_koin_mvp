package com.app.daniel.app.domain.usecases

import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.domain.repository.MoviesRepository
import com.app.daniel.app.domain.usecases.MovieRequestType.*
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class OnMoviesRequestUseCase constructor(private val repository: MoviesRepository) :
    UseCase<Movie>(), KoinComponent {

    override fun buildUseCase(): Single<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun onRequestedMovies(page: Int, requestType: MovieRequestType): Single<List<Movie>> {
        return when (requestType) {
            POPULAR -> {
                repository.fetchPopularMovies(requestedEndpointPage = page)
            }
            UPCOMING -> {
                repository.fetchUpcomingMovies(requestedEndpointPage = page)
            }
            TOP_RATED -> {
                repository.fetchTopRatedMovies(requestedEndpointPage = page)

            }
        }
    }

    fun onRequestedMovieDetails(id: String): Single<Movie> {
        return repository.retrieveById(id)
    }
}