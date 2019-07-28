package com.app.daniel.app.movieapp.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.ext.android.inject

class MoviesFragment : BaseFragment<MoviesContract.MoviePresenter>(), MoviesContract.MoviesView{

    override val presenter : MoviesContract.MoviePresenter by  inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies,null)
    }

    override fun onStartView() {
    }

    override fun onLayoutItemsChangeOrientation() {
    }

    override fun getMovies(movies: List<Movie>) {
        movies.size
    }

    override fun onLoadingState() {
        state_message.text = getString(R.string.making_request)
    }

    override fun onCompleteState() {
        progressLayout.visibility = View.GONE
        moviesRecycler.visibility = View.VISIBLE
    }

    override fun onErrorState() {

    }


}