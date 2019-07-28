package com.app.daniel.app.data.repository

import com.app.daniel.app.commons.Constants
import com.app.daniel.app.commons.applyScheduler
import com.app.daniel.app.data.adapters.MovieAdapter
import com.app.daniel.app.data.services.MovieService
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.domain.repository.MoviesRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject



class MovieRepositoryImpl : MoviesRepository, KoinComponent {

    private val movieService: MovieService by inject()

    override fun fetchPopularMovies(requestedEndpointPage: Int): Single<List<Movie>> {
        return movieService
            .popularMovies(Constants.MovieApi.CLIENT_TOKEN,page = requestedEndpointPage)
            .applyScheduler()
            .map { response ->
                val movies = ArrayList<Movie>()
                return@map response.result.mapTo(destination = movies) { movieEntity -> MovieAdapter.toMovie(movieEntity) }
            }
    }

override fun fetchUpcomingMovies(requestedEndpointPage: Int): Single<List<Movie>> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

override fun fetchTopRatedMovies(requestedEndpointPage: Int): Single<List<Movie>> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

}