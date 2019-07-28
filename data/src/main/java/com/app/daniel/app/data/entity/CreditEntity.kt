package com.app.daniel.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = CreditEntity.ENTITY_NAME)
data class CreditEntity(
    @PrimaryKey
    @SerializedName(ID)
    var id : Int,

    @SerializedName(CAST)
    var cast : String
) {
    companion object{
        const val ENTITY_NAME = "credit"
        const val ID = "id"
        const val CAST = "cast"
    }
}