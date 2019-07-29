package com.app.daniel.app.movieapp.movies.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.daniel.app.domain.dto.Movie
import com.app.daniel.app.domain.usecases.MovieRequestType
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.BaseFragment
import com.app.daniel.app.movieapp.movies.MoviesAdapter
import com.app.daniel.app.movieapp.movies.MoviesContract
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class UpcomingMoviesFragment : BaseFragment<MoviesContract.MoviePresenter>(), MoviesContract.MoviesView {

    override val presenter: MoviesContract.MoviePresenter  by inject { parametersOf(this) }
    private lateinit var movies: MutableList<Movie>
    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    private var page: Int = 1
    private lateinit var movieAdapter: MoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        app_name.text = getString(R.string.upcoming_movies)
        onStartView()
    }

    override fun onStartView() {
        presenter.fetchPopularMovies(page,MovieRequestType.UPCOMING)
    }

    override fun onLayoutItemsChangeOrientation() {
    }

    override fun getMovies(fetchedMovies: List<Movie>) {
        if (page > 1) {
            val previousMovieListSize = movies.size-1
            movies.addAll(fetchedMovies)
            movieAdapter.notifyItemRangeInserted(previousMovieListSize, fetchedMovies.size-1)
        } else {
            movies = fetchedMovies.toMutableList()
        }
    }

    override fun onLoadingState() {
        state_message.text = getString(R.string.making_request)
        progressLayout.visibility = View.VISIBLE
        moviesRecycler.visibility = View.GONE
    }

    override fun onCompleteState() {
        if (page <= 1) {
            staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            moviesRecycler.layoutManager = staggeredGridLayoutManager
            staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
            registerForContextMenu(moviesRecycler)
            movieAdapter = MoviesAdapter(movies)
            moviesRecycler.adapter = movieAdapter
        }
        progressLayout.visibility = View.GONE
        moviesRecycler.visibility = View.VISIBLE
        addRecyclerViewOnScrollListener()
    }

    private fun addRecyclerViewOnScrollListener() {
        moviesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var pastItems = 0
                val visibleItemCount = staggeredGridLayoutManager.childCount
                val totalItemCount = staggeredGridLayoutManager.itemCount
                val firstVisibleItems = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)
                if (firstVisibleItems != null && firstVisibleItems.isNotEmpty()) {
                    pastItems = firstVisibleItems[0]
                }
                if (visibleItemCount + pastItems >= totalItemCount && firstVisibleItems!!.size >= 0) {
                    recyclerView.removeOnScrollListener(this)
                    page += 1
                    presenter.fetchPopularMovies(page,MovieRequestType.UPCOMING)
                }
            }
        })
    }

    override fun onErrorState() {
        progressLayout.visibility = View.GONE
        moviesRecycler.visibility = View.VISIBLE
        addRecyclerViewOnScrollListener()
    }


}