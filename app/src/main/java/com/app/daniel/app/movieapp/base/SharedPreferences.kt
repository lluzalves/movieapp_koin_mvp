package com.app.daniel.app.movieapp.base

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPreferences(applicationContext: Context) {

    private var sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

    fun saveMovieId(name: String) {
        sharedPreferences.edit().putString(MOVIE_ID, name).apply()
    }

    fun getMovieId(): String = sharedPreferences.getString(MOVIE_ID, "") ?: ""


    companion object {
        const val MOVIE_ID = "movie_id"
    }

}