package com.app.daniel.app.data.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.daniel.app.data.entity.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {

    @Query("select * from movies")
    fun retrieveMovies(): Single<List<MovieEntity>>

    @Query("select * from movies where  id = :movieId")
    fun retrieveMovies(movieId: String): Single<List<MovieEntity>>

    @Query("delete from movies where  id = :movieId")
    fun deleteMovie(movieId: String): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: MovieEntity): Single<Long>
}