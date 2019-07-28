package com.app.daniel.app.domain.dto

data class Movie(
    val id: Int,
    val title: String?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val overview: String?,
    val posterPath: String?,
    val homePage: String?,
    val countries: List<Country>?,
    val companies: List<Company>?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val releaseDate: String?,
    val runtime: String?,
    val languages: List<Language>?,
    val genres: List<Int>?,
    val status: Boolean?
)