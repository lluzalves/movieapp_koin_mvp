package com.app.daniel.app.data.converters

import androidx.room.TypeConverter
import com.app.daniel.app.data.entity.Company
import com.app.daniel.app.data.entity.Country
import com.app.daniel.app.data.entity.Language
import com.google.gson.Gson


class CountryConverter {
    @TypeConverter
    fun listToJson(value: List<Country>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<Country> {

        val entity = Gson().fromJson(value, Array<Country>::class.java) as Array<Country>
        return entity.toList()
    }
}

class CompanyConverter {
    @TypeConverter
    fun listToJson(value: List<Company>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<Company> {

        val entity = Gson().fromJson(value, Array<Company>::class.java) as Array<Company>
        return entity.toList()
    }
}

class LanguageConverter {
    @TypeConverter
    fun listToJson(value: List<Language>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun  jsonToList(value: String): List<Language> {

        val entity = Gson().fromJson(value, Array<Language>::class.java) as Array<Language>
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