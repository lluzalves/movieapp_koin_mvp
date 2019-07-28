package com.app.daniel.app.movieapp.movies

import android.view.View
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.base.BaseViewHolder
import android.widget.ImageView
import com.app.daniel.app.commons.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_movie_item.view.*


class MoviesViewHolder constructor(itemView: View) : BaseViewHolder<Movie>(itemView),
    View.OnClickListener {
    private lateinit var movie: Movie

    override fun show(model: Movie) {
        movie = model
        movie.posterPath?.let { setMovieCover(it) }
        }

    private fun setMovieCover(posterPath: String) {
        Picasso.with(itemView.context)
            .load(Constants.MovieApi.PICTURE_PATH + posterPath)
            .into(itemView.movieCover as ImageView)
    }

    override fun onClick(v: View) {
        when (v) {
            itemView.movieCover -> {

            }
        }
    }
}