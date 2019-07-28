package com.app.daniel.app.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = LanguageEntity.ENTITY_NAME)
data class LanguageEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = CountryEntity.ID)
    var id: Long = System.currentTimeMillis(),

    @SerializedName(ISO)
    val iso: String,

    @SerializedName(NAME)
    val name: String
) {
    companion object {
        const val ENTITY_NAME = "language"
        const val NAME = "name"
        const val ISO = "iso_639_1"
    }

}