package com.app.daniel.app.movieapp.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.R

class MoviesAdapter constructor(private val movies: List<Movie>) : RecyclerView.Adapter<MoviesViewHolder>() {

    lateinit var holder: MoviesViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_movie_item, null)
        holder = MoviesViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.show(movies[position])
    }
}