package com.app.daniel.app.commons

import com.app.daniel.app.commons.AppSchedulers.mainThreadScheduler
import com.app.daniel.app.commons.AppSchedulers.networkScheduler
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.applyScheduler(): Observable<T> = this.compose { observable ->
    observable
        .subscribeOn(networkScheduler())
        .observeOn(mainThreadScheduler())
}

fun <T> Single<T>.applyScheduler(): Single<T> = this.compose { single ->
    single
        .subscribeOn(networkScheduler())
        .observeOn(mainThreadScheduler())
}

object AppSchedulers{

    fun networkScheduler() : Scheduler {
        return Schedulers.io()
    }

    fun mainThreadScheduler() : Scheduler {
        return AndroidSchedulers.mainThread()
    }

}