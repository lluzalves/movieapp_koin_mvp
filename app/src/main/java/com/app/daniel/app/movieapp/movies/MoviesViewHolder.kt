package com.app.daniel.app.movieapp.movies

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.navigation.Navigation
import com.app.daniel.app.data.services.MovieApiUrls
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.BaseViewHolder
import com.app.daniel.app.movieapp.base.SharedPreferences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_movie_item.view.*


class MoviesViewHolder constructor(itemView: View) : BaseViewHolder<Movie>(itemView),
    View.OnClickListener {
    private lateinit var movie: Movie

    override fun show(model: Movie) {
        movie = model
        movie.posterPath?.let { setMovieCover(it) }
        itemView.movieCover.setOnClickListener(this)
    }

    private fun setMovieCover(posterPath: String) {
        Picasso.with(itemView.context)
            .load(MovieApiUrls.MovieApi.PICTURE_PATH + posterPath)
            .into(itemView.movieCover as ImageView)
    }

    override fun onClick(v: View) {
        when (v) {
            itemView.movieCover -> {
                SharedPreferences(itemView.context).saveMovieId(movie.id.toString())
                Navigation.findNavController(itemView).navigate(R.id.movieDetailsFragment)
            }
        }
    }
}