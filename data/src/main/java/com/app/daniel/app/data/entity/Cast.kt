package com.app.daniel.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = Cast.ENTITY_NAME)
data class Cast(
    @SerializedName(CHARACTER)
    var character: String,

    @PrimaryKey
    @SerializedName(CAST_ID)
    var castId: Int,

    @SerializedName(GENDER)
    var gender: String,

    @SerializedName(ID)
    var idPeople: Int,

    @SerializedName(NAME)
    var name: String,

    @SerializedName(ORDER)
    var order: String,

    @SerializedName(PROFILE_PATH)
    var profilePath: String
) {
    companion object {
        const val ENTITY_NAME = "cast"
        const val CHARACTER = "character"
        const val CAST_ID = "character"
        const val GENDER = "character"
        const val ID = "character"
        const val NAME = "character"
        const val ORDER = "character"
        const val PROFILE_PATH = "character"
    }
}