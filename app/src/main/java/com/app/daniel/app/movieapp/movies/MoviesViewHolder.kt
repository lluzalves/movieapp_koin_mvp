package com.app.daniel.app.movieapp.movies

import android.view.View
import android.widget.ImageView
import androidx.navigation.Navigation
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.BaseViewHolder
import com.app.daniel.app.movieapp.base.SharedPreferences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_movie_item.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const val PICTURE_PATH = "https://image.tmdb.org/t/p/w500/"

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
            .load(PICTURE_PATH + posterPath)
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