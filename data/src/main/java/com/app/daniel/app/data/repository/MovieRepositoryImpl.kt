package com.app.daniel.app.data.repository

import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.domain.repository.MoviesRepository
import io.reactivex.Single

class MovieRepositoryImpl : MoviesRepository {
    override fun insertItem(item: Movie): Single<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteItem(item: Movie): Single<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveListOf(): Single<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveById(id: String): Single<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}