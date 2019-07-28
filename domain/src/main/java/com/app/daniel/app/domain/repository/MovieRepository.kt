package com.app.daniel.app.domain.repository

import com.app.daniel.app.domain.dto.Movie

interface MoviesRepository : Repository<Movie> {
    fun fetchMovies()
}