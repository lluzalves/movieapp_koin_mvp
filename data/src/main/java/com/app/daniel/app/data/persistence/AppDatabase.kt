package com.app.daniel.app.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.daniel.app.data.converters.CompanyConverter
import com.app.daniel.app.data.converters.CountryConverter
import com.app.daniel.app.data.converters.IntConverter
import com.app.daniel.app.data.converters.LanguageConverter
import com.app.daniel.app.data.entity.CompanyEntity
import com.app.daniel.app.data.entity.CountryEntity
import com.app.daniel.app.data.entity.LanguageEntity
import com.app.daniel.app.data.entity.MovieEntity
import com.app.daniel.app.data.persistence.dao.MovieDao

@Database(entities = [MovieEntity::class, LanguageEntity::class, CompanyEntity::class, CountryEntity::class], version = 1)
@TypeConverters(CompanyConverter::class,CountryConverter::class,LanguageConverter::class,IntConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}