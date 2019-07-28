package com.app.daniel.app.data.converters

import androidx.room.TypeConverter
import com.app.daniel.app.data.entity.CompanyEntity
import com.app.daniel.app.data.entity.CountryEntity
import com.app.daniel.app.data.entity.LanguageEntity
import com.google.gson.Gson


class CountryConverter {
    @TypeConverter
    fun listToJson(value: List<CountryEntity>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<CountryEntity> {

        val entity = Gson().fromJson(value, Array<CountryEntity>::class.java) as Array<CountryEntity>
        return entity.toList()
    }
}

class CompanyConverter {
    @TypeConverter
    fun listToJson(value: List<CompanyEntity>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<CompanyEntity> {

        val entity = Gson().fromJson(value, Array<CompanyEntity>::class.java) as Array<CompanyEntity>
        return entity.toList()
    }
}

class LanguageConverter {
    @TypeConverter
    fun listToJson(value: List<LanguageEntity>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<LanguageEntity> {

        val entity = Gson().fromJson(value, Array<LanguageEntity>::class.java) as Array<LanguageEntity>
        return entity.toList()
    }
}


class IntConverter {
    @TypeConverter
    fun listToJson(value: List<Int>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<Int> {

        val entity = Gson().fromJson(value, Array<Int>::class.java) as Array<Int>
        return entity.toList()
    }
}