package com.app.daniel.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = CastEntity.ENTITY_NAME)
data class CastEntity(
    @SerializedName(CHARACTER)
    var character: String?,

    @PrimaryKey
    @SerializedName(CAST_ID)
    var castId: Int,

    @SerializedName(GENDER)
    var gender: String?,

    @SerializedName(ID)
    var idPeople: Int?,

    @SerializedName(NAME)
    var name: String?,

    @SerializedName(ORDER)
    var order: String?,

    @SerializedName(PROFILE_PATH)
    var profilePath: String?
) {
    companion object {
        const val ENTITY_NAME = "cast"
        const val CHARACTER = "character"
        const val CAST_ID = "cast_id"
        const val GENDER = "cast_gender"
        const val ID = "id"
        const val NAME = "cast_name"
        const val ORDER = "cast_order"
        const val PROFILE_PATH = "cast_pofile"
    }
}