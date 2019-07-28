package com.app.daniel.app.data.di

import androidx.room.Room
import com.app.daniel.app.commons.Constants
import com.app.daniel.app.data.network.NetworkFactory
import com.app.daniel.app.data.persistence.AppDatabase
import com.app.daniel.app.data.repository.MovieRepositoryImpl
import com.app.daniel.app.data.services.MovieService
import org.koin.dsl.module

val networkModule = module(override = true) {
    factory <MovieService> {
        NetworkFactory().webService(Constants.MovieApi.BASE_URL).newBuilder().build().create(MovieService::class.java)
    }
}

val dataModule = module(override = true){
    single { Room.databaseBuilder(get(),AppDatabase::class.java,"db_name").build() }
    single { get<AppDatabase>().movieDao }
    single { MovieRepositoryImpl() }
}