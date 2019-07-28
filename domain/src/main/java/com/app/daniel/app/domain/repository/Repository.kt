package com.app.daniel.app.domain.repository

import io.reactivex.Single

interface Repository<T> {
    fun retrieveListOf(): Single<List<T>>
    fun retrieveById(id: String): Single<T>
    fun insertItem(item: T): Single<Long>
    fun deleteItem(item: T): Single<Long>
}