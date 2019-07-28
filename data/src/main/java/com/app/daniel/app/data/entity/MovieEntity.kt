package com.app.daniel.app.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.app.daniel.app.data.converters.*
import com.app.daniel.app.data.entity.MovieEntity.Companion.ENTITY_NAME
import com.google.gson.annotations.SerializedName


@Entity(tableName = ENTITY_NAME)
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @SerializedName(ID)
    @ColumnInfo(name = ID)
    var id: Int = 0,

    @SerializedName(TITLE)
    @ColumnInfo(name = TITLE)
    var title: String?,

    @SerializedName(ORIGINAL_TITLE)
    @ColumnInfo(name = ORIGINAL_TITLE)
    var originalTitle: String?,

    @SerializedName(ORIGINAL_LANGUAGE)
    @ColumnInfo(name = ORIGINAL_LANGUAGE)
    var originalLanguage: String?,

    @SerializedName(OVERVIEW)
    @ColumnInfo(name = OVERVIEW)
    var overview: String?,

    @SerializedName(POSTER_PATH)
    @ColumnInfo(name = POSTER_PATH)
    var posterPath: String?,

    @SerializedName(HOMEPAGE)
    @ColumnInfo(name = HOMEPAGE)
    var homePage: String?,

    @SerializedName(PRODUCTION_COUNTRIES)
    @TypeConverters(CountryConverter::class)
    var countries: List<CountryEntity>?,

    @SerializedName(PRODUCTION_COMPANIES)
    @TypeConverters(CompanyConverter::class)
    var companyEntities: List<CompanyEntity>?,

    @SerializedName(VOTE_AVG)
    @ColumnInfo(name = VOTE_AVG)
    var voteAverage: Double?,

    @SerializedName(VOTE_COUNT)
    @ColumnInfo(name = VOTE_COUNT)
    var voteCount: Int?,

    @SerializedName(RELEASE_DATE)
    @ColumnInfo(name = RELEASE_DATE)
    var releaseDate: String?,

    @SerializedName(RUNTIME)
    @ColumnInfo(name = RUNTIME)
    var runtime: String?,

    @SerializedName(SPOKEN_LANG)
    @TypeConverters(LanguageConverter::class)
    var languages: List<LanguageEntity>?,

    @SerializedName(GENRE_IDS)
    @TypeConverters(IntConverter::class)
    var genres: List<Int>?,

    @SerializedName(STATUS)
    var status: Boolean?
) {

    companion object {
        const val ENTITY_NAME = "movies"
        const val ID = "id"
        const val TITLE = "title"
        const val ORIGINAL_TITLE = "original_title"
        const val ORIGINAL_LANGUAGE = "original_language"
        const val STATUS = "status"
        const val GENRE_IDS = "genre_ids"
        const val RUNTIME = "runtime"
        const val RELEASE_DATE = "release_date"
        const val VOTE_COUNT = "vote_count"
        const val VOTE_AVG = "voteAverage"
        const val SPOKEN_LANG = "spoken_languages"
        const val PRODUCTION_COMPANIES = "production_companies"
        const val PRODUCTION_COUNTRIES = "production_countries"
        const val POSTER_PATH = "poster_path"
        const val OVERVIEW = "overview"
        const val HOMEPAGE = "homepage"
    }
}