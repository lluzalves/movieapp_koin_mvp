package com.app.daniel.app.domain.dto

data class Company(
    val description: String,
    val headquarters: String,
    val id: String,
    val name: String,
    val logo_path: String,
    val parent_company: String
)