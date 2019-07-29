package com.app.daniel.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = CompanyEntity.ENTITY_NAME)
data class CompanyEntity(
    @SerializedName(DESCRIPTION)
    val description: String?,
    @SerializedName(HQ)
    val headquarters: String?,
    @PrimaryKey
    @SerializedName(ID)
    val id: String,
    @SerializedName(NAME)
    val name: String?,
    @SerializedName(LOGO_PTH)
    val logo_path: String?,
    @SerializedName(PARENT_COMPANY)
    val parent_company: String?
) {
    companion object {
        const val ENTITY_NAME = "company"
        const val DESCRIPTION = "description"
        const val HQ = "headquarters"
        const val ID = "id"
        const val NAME = "name"
        const val LOGO_PTH = "logo_path"
        const val PARENT_COMPANY = "parent_company"
    }
}