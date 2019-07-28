package com.app.daniel.app.movieapp.application

import android.app.Application
import com.app.daniel.app.data.di.modules.dataModule
import com.app.daniel.app.data.di.modules.networkModule
import com.app.daniel.app.movieapp.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            // declare used Android context
            androidContext(this@MovieApp)
            // declare modules
            modules(listOf(applicationModule, dataModule, networkModule))
        }
    }
}