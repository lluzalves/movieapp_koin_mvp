package com.app.daniel.app.movieapp.base

import android.content.Context
import androidx.work.*
import com.app.daniel.app.movieapp.R
import com.app.daniel.app.movieapp.base.work.NetworkWorkInfoState
import com.app.daniel.app.movieapp.base.work.NetworkStateIWorkState
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber


abstract class BasePresenter<V : MvpView> : MvpPresenter<V>, NetworkWorkInfoState {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var applicationContext: Context

    fun isViewAttached() {
        if (view != null) return
        throw MvpViewExceptionImpl().onAttachedException()
    }

    override fun onDetach() {
        compositeDisposable.clear()
    }

    override fun checkConnectivity(applicationContext: Context) {
        this.applicationContext = applicationContext
        WorkManager.getInstance(applicationContext.applicationContext)
            .beginUniqueWork(
                NetworkStateIWorkState.NAME,
                ExistingWorkPolicy.REPLACE,
                buildWorkRequest(NetworkStateIWorkState::class.java, NetworkStateIWorkState.TAG)
            )
            .enqueue()
        WorkManager.getInstance(applicationContext.applicationContext)
            .getWorkInfosByTagLiveData(NetworkStateIWorkState.TAG)
            .observeForever(this)
    }

    override fun onConnectivity(isConnected: Boolean): Boolean {
        return isConnected
    }

    override fun onChanged(worksInfo: List<WorkInfo>) {
        worksInfo.indices.asSequence().map { workItem -> worksInfo[workItem] }.forEach { workItem ->
            when (workItem.state) {
                WorkInfo.State.ENQUEUED, WorkInfo.State.BLOCKED -> {
                    Timber.d("Network work is enqueued or blocked")
                }
                WorkInfo.State.RUNNING -> {
                    Timber.d("Network work is running")
                    view.onLoading(applicationContext.getString(R.string.please_wait))

                }
                WorkInfo.State.SUCCEEDED -> {
                    Timber.d("Network is available")
                    onConnectivity(isConnected = true)
                }
                WorkInfo.State.CANCELLED -> {
                    Timber.d("Network work was cancelled")
                    onConnectivity(isConnected = false)
                }
                WorkInfo.State.FAILED -> {
                    Timber.d("Network work failed or no network is available")
                    view.onError(applicationContext.getString(R.string.unable_to_detect_connectivity))
                }
            }
        }
        WorkManager.getInstance(applicationContext).getWorkInfosByTagLiveData(NetworkStateIWorkState.TAG)
            .removeObserver(this)
        WorkManager.getInstance(applicationContext).pruneWork()
    }


    private fun buildWorkRequest(worker: Class<out ListenableWorker>, tag: String): OneTimeWorkRequest {
        return OneTimeWorkRequest.Builder(worker)
            .addTag(tag)
            .build()
    }
}