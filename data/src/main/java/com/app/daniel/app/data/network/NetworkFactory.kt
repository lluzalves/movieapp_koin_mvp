package com.app.daniel.app.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkFactory : INetworkFactory, KoinComponent {

    private val context: Context by inject()

    private val cacheLimitSize = (8 * 1024 * 1024).toLong()
    private val applicationCache = Cache(context.cacheDir, cacheLimitSize)

    override fun webService(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(baseUrl)
            .build()
    }

    override fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .cache(applicationCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = when {
                    hasNetworkConnectivity() -> {
                        val period = 10  // seconds
                        request.newBuilder().header(name = "Cache-Control", value = "public, max-age=$period").build()
                    }
                    else -> {
                        val period = 60 * 60 * 24 * 4  // 4 days
                        request.newBuilder()
                            .header(name = "Cache-Control", value = "public, only-if-cached, max-stale=$period").build()
                    }
                }
                chain.proceed(request)
            }.connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(4, TimeUnit.MINUTES)
            .readTimeout(4, TimeUnit.MINUTES)
            .retryOnConnectionFailure(false)
            .build()
    }


    private fun hasNetworkConnectivity(): Boolean {
        val connectivityManager =
            context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}