package com.app.daniel.app.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = CountryEntity.ENTITY_NAME)
data class CountryEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = ID)
    var id: Long = System.currentTimeMillis(),

    @SerializedName(ISO)
    val iso: String?,

    @SerializedName(NAME)
    val name: String?
) {
    companion object {
        const val ENTITY_NAME = "country"
        const val ISO = "iso"
        const val ID = "id"
        const val NAME = "name"
    }
}