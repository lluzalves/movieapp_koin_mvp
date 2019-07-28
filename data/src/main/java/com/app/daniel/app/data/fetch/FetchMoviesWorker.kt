package com.app.daniel.app.data.fetch

import android.content.Context
import androidx.work.RxWorker
import androidx.work.WorkerParameters
import com.app.daniel.app.commons.Constants
import com.app.daniel.app.commons.applyScheduler
import com.app.daniel.app.data.services.MovieResponse
import com.app.daniel.app.data.services.MovieService
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class FetchMoviesWorker constructor(appContext: Context, workerParameters: WorkerParameters) :
    RxWorker(appContext, workerParameters), KoinComponent {

    private val movieService: MovieService by inject()

    override fun createWork(): Single<Result> {
        return fetchMovies().map { response ->
            response.totalResult
            Result.success()
        }
    }

    private fun fetchMovies(): Single<MovieResponse> {
        return movieService
            .popularMovies(Constants.MovieApi.CLIENT_TOKEN)
            .applyScheduler()
            .map {
                    response -> return@map response
            }
    }

}