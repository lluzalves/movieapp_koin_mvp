package com.app.daniel.app.data.services

import com.app.daniel.app.data.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName(PAGE)
    val page: Int = 0,

    @SerializedName(TOTAL_RESULTS)
    val totalResult: Int = 0,

    @SerializedName(TOTAL_PAGES)
    val totalPages: Int = 0,

    @SerializedName(RESULT)
    val result: ArrayList<MovieEntity>
) {
    companion object {
        const val PAGE = "page"
        const val TOTAL_RESULTS = "total_results"
        const val TOTAL_PAGES = "total_pages"
        const val RESULT = "results"
    }
}