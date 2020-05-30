package com.app.daniel.app.data.di

import androidx.room.Room
import com.app.daniel.app.data.BuildConfig
import com.app.daniel.app.data.network.NetworkChecker
import com.app.daniel.app.data.persistence.AppDatabase
import com.app.daniel.app.data.repository.MovieRepositoryImpl
import com.app.daniel.app.data.services.MovieApiUrls
import com.app.daniel.app.data.services.MovieService
import com.app.daniel.app.domain.repository.MoviesRepository
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val dataModule = module(override = true) {
    single(named("room_database")) {
        Room.databaseBuilder(get(), AppDatabase::class.java, "db_name").build()
    }
    single { get<AppDatabase>(named("room_database")).movieDao }
    single { return@single MovieRepositoryImpl(movieService = get(named("movie_service"))) as MoviesRepository }
}

val networkModule = module(override = true) {
    val context = GlobalContext.get().koin.rootScope.androidContext()
    val cacheLimitSize = (25 * 1024 * 1024).toLong() //25mb
    val applicationCache = Cache(context.cacheDir, cacheLimitSize)

    factory(named("ok_http_client")) {
        OkHttpClient().newBuilder()
            .cache(applicationCache)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.BASIC
                }
            })
            .addInterceptor { chain ->
                var request = chain.request()
                request = when {
                    NetworkChecker(get()).hasNetworkConnectivity() -> {
                        val period = 10  // seconds
                        request.newBuilder()
                            .header(name = "Cache-Control", value = "public, max-age=$period")
                            .build()
                    }
                    else -> {
                        val period = 60 * 60 * 24 * 4  // 4 days
                        request.newBuilder()
                            .header(
                                name = "Cache-Control",
                                value = "public, only-if-cached, max-stale=$period"
                            ).build()
                    }
                }
                chain.proceed(request)
            }
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(4, TimeUnit.MINUTES)
            .readTimeout(4, TimeUnit.MINUTES)
            .retryOnConnectionFailure(false)
            .build()
    }
    factory<MovieService>(named("movie_service")) {
        val okHttpClient = get<OkHttpClient>(named("ok_http_client"))
        Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(MovieApiUrls.MovieApi.BASE_URL)
            .build()
            .create(MovieService::class.java)
    }

}