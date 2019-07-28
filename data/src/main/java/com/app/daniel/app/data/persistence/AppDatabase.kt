package com.app.daniel.app.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.daniel.app.data.converters.CompanyConverter
import com.app.daniel.app.data.converters.CountryConverter
import com.app.daniel.app.data.converters.IntConverter
import com.app.daniel.app.data.converters.LanguageConverter
import com.app.daniel.app.data.entity.Company
import com.app.daniel.app.data.entity.Country
import com.app.daniel.app.data.entity.Language
import com.app.daniel.app.data.entity.MovieEntity
import com.app.daniel.app.data.persistence.dao.MovieDao

@Database(entities = [MovieEntity::class, Language::class, Company::class, Country::class], version = 1)
@TypeConverters(CompanyConverter::class,CountryConverter::class,LanguageConverter::class,IntConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}