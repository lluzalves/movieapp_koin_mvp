package com.app.daniel.app.movieapp

import com.app.daniel.app.data.BuildConfig
import com.app.daniel.app.data.services.MovieApiUrls
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_SERVER_URL = "https://bff_contracao/v1/investidor"
class MockWebServerHelper {
    private val mockWebServer = MockWebServer()
    private lateinit var apiClient: Retrofit

    fun buildApiClient(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(MovieApiUrls.MovieApi.BASE_URL)
            .build()
    }

    fun getOkHttpClient(): OkHttpClient {
        val context = GlobalContext.get().koin.rootScope.androidContext()
        val cacheLimitSize = (25 * 1024 * 1024).toLong() //25mb
        val applicationCache = Cache(context.cacheDir, cacheLimitSize)
        return OkHttpClient().newBuilder()
            .cache(applicationCache)
            .addInterceptor(HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY })
            .addInterceptor { chain ->
                var request = chain.request()
                val period = 10  // seconds
                request = request.newBuilder()
                    .header(name = "Cache-Control", value = "public, max-age=$period")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(4, TimeUnit.MINUTES)
            .readTimeout(4, TimeUnit.MINUTES)
            .retryOnConnectionFailure(false)
            .build()
    }

    fun <T> createService(service: Class<T>): Class<T> {
        return buildApiClient().create(service::class.java)
    }

    fun startServer() {
        mockWebServer.start()
    }

    fun stopServer(){
        mockWebServer.shutdown()
    }

    fun getResponse(responseCode : Int, bodyPath : String) : MockResponse{
        return MockResponse()
            .setResponseCode(responseCode)
            .setBody(bodyPath)
    }
}