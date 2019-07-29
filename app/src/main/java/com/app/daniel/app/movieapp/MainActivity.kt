package com.app.daniel.app.movieapp

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.app.daniel.app.movieapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        addToClickListener()
    }

    private fun addToClickListener() {
        popular.setOnClickListener(this)
        topRated.setOnClickListener(this)
        upComing.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.popular -> {
                topRated.setBackgroundColor(resources.getColor(R.color.cardview_dark_background, null))
                upComing.setBackgroundColor(resources.getColor(R.color.cardview_dark_background, null))
                popular.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark, null))
                popular.setOnClickListener(null)
                topRated.setOnClickListener(this)
                upComing.setOnClickListener(this)
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.popularMoviesFragment)
            }
            R.id.topRated -> {
                popular.setBackgroundColor(resources.getColor(R.color.cardview_dark_background, null))
                upComing.setBackgroundColor(resources.getColor(R.color.cardview_dark_background, null))
                topRated.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark, null))
                topRated.setOnClickListener(null)
                popular.setOnClickListener(this)
                upComing.setOnClickListener(this)
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.topMoviesFragment)
            }
            R.id.upComing -> {
                popular.setBackgroundColor(resources.getColor(R.color.cardview_dark_background, null))
                topRated.setBackgroundColor(resources.getColor(R.color.cardview_dark_background, null))
                upComing.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark, null))
                upComing.setOnClickListener(null)
                popular.setOnClickListener(this)
                topRated.setOnClickListener(this)
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.upcomingMoviesFragment)
            }
        }
    }
}
