package com.app.daniel.app.movieapp.movies.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.app.daniel.app.data.services.MovieApiUrls
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.BaseFragment
import com.app.daniel.app.movieapp.base.SharedPreferences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_movie.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class MovieDetailsFragment : BaseFragment<MovieDetailsContract.MovieDetailsPresenter>(),
    MovieDetailsContract.MovieDetailsView {

    override val presenter: MovieDetailsContract.MovieDetailsPresenter  by inject { parametersOf(this) }

    private val preferencesManager: SharedPreferences by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details_movie, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onStartView()
    }

    override fun onStartView() {
        val movieId = preferencesManager.getMovieId()
        presenter.fetchMovieDetails(movieId)
    }

    override fun getMovie(movie: Movie) {
        updateUi(movie)
    }

    private fun updateUi(movie: Movie) {
        Picasso.with(context)
            .load(MovieApiUrls.MovieApi.PICTURE_PATH + movie.posterPath)
            .into(movieView)
        movieName.text = movie.title
        movieDescription.text = movie.overview.orEmpty()
        movieDate.text = movie.releaseDate.orEmpty()
        movieDuration.text = movie.runtime.orEmpty()
        movieScore.text = movie.voteCount.toString()
        movieOriginalLanguage.text = movie.originalLanguage.orEmpty()
        ll_movie_details.visibility = View.VISIBLE
    }


    override fun onLoadingState() {

    }

    override fun onCompleteState() {

    }


    override fun onErrorState() {

    }


}