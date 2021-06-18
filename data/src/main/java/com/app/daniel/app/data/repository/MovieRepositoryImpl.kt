package com.app.daniel.app.data.repository

import com.app.daniel.app.commons.applyScheduler
import com.app.daniel.app.data.adapters.MovieAdapter
import com.app.daniel.app.data.services.MovieApiUrls
import com.app.daniel.app.data.services.MovieService
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.domain.repository.MoviesRepository
import io.reactivex.Single


class MovieRepositoryImpl constructor(private val movieService: MovieService) : MoviesRepository {

    override fun fetchPopularMovies(requestedEndpointPage: Int): Single<List<Movie>> {
        return movieService
            .popularMovies(MovieApiUrls.Urls.buildMovieRequestUrl(page = requestedEndpointPage))
            .applyScheduler()
            .map { response ->
                val movies = ArrayList<Movie>()
                return@map response.result.mapTo(destination = movies) { movieEntity ->
                    MovieAdapter.toMovie(
                        movieEntity
                    )
                }
            }
    }

    override fun fetchUpcomingMovies(requestedEndpointPage: Int): Single<List<Movie>> {
        return movieService
            .upComingMovies(MovieApiUrls.Urls.buildMovieRequestUrl(page = requestedEndpointPage))
            .applyScheduler()
            .map { response ->
                return@map response.result.mapTo(destination = ArrayList()) { movieEntity ->
                    MovieAdapter.toMovie(
                        movieEntity
                    )
                }
            }
    }

    override fun fetchTopRatedMovies(requestedEndpointPage: Int): Single<List<Movie>> {
        return movieService
            .topRatedMovies(MovieApiUrls.Urls.buildMovieRequestUrl(page = requestedEndpointPage))
            .applyScheduler()
            .map { response ->
                val movies = ArrayList<Movie>()
                return@map response.result.mapTo(destination = movies) { movieEntity ->
                    MovieAdapter.toMovie(
                        movieEntity
                    )
                }
            }
    }

    override fun insertItem(item: Movie): Single<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteItem(item: Movie): Single<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveListOf(): Single<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveById(id: String): Single<Movie> {
        return movieService
            .movieDetails(id, MovieApiUrls.MovieApi.CLIENT_TOKEN)
            .applyScheduler()
            .map { movieEntity ->
                MovieAdapter.toMovie(movieEntity)
            }
    }
}