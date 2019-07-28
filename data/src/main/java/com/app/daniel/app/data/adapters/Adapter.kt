package com.app.daniel.app.data.adapters

import com.app.daniel.app.data.entity.CompanyEntity
import com.app.daniel.app.data.entity.CountryEntity
import com.app.daniel.app.data.entity.LanguageEntity
import com.app.daniel.app.data.entity.MovieEntity
import com.app.daniel.app.domain.dto.Company
import com.app.daniel.app.domain.dto.Country
import com.app.daniel.app.domain.dto.Language
import com.app.daniel.app.domain.dto.Movie

object MovieAdapter {
    fun toMovie(movieEntity: MovieEntity) = Movie(
        id = movieEntity.id,
        title = movieEntity.title,
        originalTitle = movieEntity.originalTitle,
        posterPath = movieEntity.posterPath,
        companies = getCompanies(movieEntity.companyEntities),
        originalLanguage = movieEntity.originalLanguage,
        overview = movieEntity.overview,
        voteAverage = movieEntity.voteAverage,
        voteCount = movieEntity.voteCount,
        languages = getLanguages(movieEntity.languages),
        releaseDate = movieEntity.releaseDate,
        countries = getCountry(movieEntity.countries),
        genres = movieEntity.genres,
        homePage = movieEntity.homePage,
        status = movieEntity.status,
        runtime = movieEntity.runtime
    )

    private fun getCompanies(companyEntities: List<CompanyEntity>): List<Company> {
        val companies = ArrayList<Company>()
        companyEntities.mapTo(destination = companies) { companyList -> CompanyAdapter.toCompany(companyList) }
        return companies
    }

    private fun getCountry(countryEntities: List<CountryEntity>): List<Country> {
        val countries = ArrayList<Country>()
        countryEntities.mapTo(destination = countries) { companyList -> CountryAdapter.toCountry(companyList) }
        return countries
    }

    private fun getLanguages(languageEntity: List<LanguageEntity>): List<Language> {
        val languages = ArrayList<Language>()
        languageEntity.mapTo(destination = languages) { languageList -> LanguageAdapter.toLanguage(languageList) }
        return languages
    }

}

object CompanyAdapter {
    fun toCompany(companyEntity: CompanyEntity) = Company(
        id = companyEntity.id,
        headquarters = companyEntity.headquarters,
        name = companyEntity.name,
        logo_path = companyEntity.logo_path,
        parent_company = companyEntity.parent_company,
        description = companyEntity.description
    )
}

object CountryAdapter {
    fun toCountry(countryEntities: CountryEntity) = Country(
        id = countryEntities.id,
        iso = countryEntities.iso,
        name = countryEntities.name
    )
}

object LanguageAdapter {
    fun toLanguage(languageEntity: LanguageEntity) = Language(
        id = languageEntity.id,
        iso = languageEntity.iso,
        name = languageEntity.name
    )
}