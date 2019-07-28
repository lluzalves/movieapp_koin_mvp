package com.app.daniel.app.movieapp.splash

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.app.daniel.app.movieapp.MainActivity
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), SplashContract.SplashView {

    private lateinit var animation: AnimationDrawable
    // private val presenter: SplashContract.SplashPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        onStartView()
    }

    override fun onStartView() {
        container.setBackgroundResource(R.drawable.animation_splash_screen)
        animation = container.background as AnimationDrawable
    }

    override fun onResume() {
        super.onResume()
        startAnimation()
    }

    override fun startAnimation() {
        animation.start()
        container.setBackgroundResource(R.drawable.animation_splash_screen)
        animation = container.background as AnimationDrawable
        Handler().run {
            return@run postDelayed({
                when {
                    animation.current !== animation.getFrame(animation.numberOfFrames - 1) -> this@SplashActivity.startAnimation()
                    else -> {
                        onCompleted()
                    }
                }
            }, 50)
        }
    }


    override fun onCompleted() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}
