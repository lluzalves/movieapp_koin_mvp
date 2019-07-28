package com.app.daniel.app.commons


class Constants {
    object MovieApi {
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_VERSION = "3"
        const val CLIENT_TOKEN = "b5f144e4118ef98b20e857f95ff3e437"

        // query Strings
        const val LANGUAGE = "pt-BR"

        // movie query
        //https://api.themoviedb.org/3/search/movie?api_key=b5f144e4118ef98b20e857f95ff3e437&language=en-US&query=Run&page=1&include_adult=false
        const val MOVIE = "/movie"

        // people query
        //https://api.themoviedb.org/3/search/person?api_key=b5f144e4118ef98b20e857f95ff3e437&language=en-US&query=Ben&page=1&include_adult=false
        const val PEOPLE = "/person"

        // company query
        // https://api.themoviedb.org/3/search/company?api_key=<<api_key>>&page=1
        const val COMPANY = "/company"

        //genre query
        //https://api.themoviedb.org/3/genre/movie/list?api_key=b5f144e4118ef98b20e857f95ff3e437&language=en-US
        const val GENRE = "/genre"

        //https://api.themoviedb.org/3/credit/{credit_id}?api_key=<<api_key>>
        const val CREDITS = "/credits"

        // https://api.themoviedb.org/3/movie/popular?api_key=b5f144e4118ef98b20e857f95ff3e437&language=en-US&page=1
        const val POPULAR = "/popular"

        //https://api.themoviedb.org/3/search/movie?api_key=b5f144e4118ef98b20e857f95ff3e437&language=en-US&query=Run&page=1&include_adult=false
        const val SEARCH = "/search"

        //https://api.themoviedb.org/3/movie/now_playing?api_key=b5f144e4118ef98b20e857f95ff3e437&language=en-US&page=1
        const val PLAYING = "/now_playing"
        const val PICTURE_PATH = "https://image.tmdb.org/t/p/w500/"
    }
}