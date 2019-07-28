package com.app.daniel.app.movieapp.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.app.daniel.app.movieapp.base.BasePresenter
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

class SplashPresenter constructor(override val view: SplashContract.SplashView) :
    BasePresenter<SplashContract.SplashView>(), SplashContract.SplashPresenter,
    Observer<List<WorkInfo>>,
    KoinComponent {

    private val workManager: WorkManager by inject()
    private val request: OneTimeWorkRequest  by inject()
    private val workRequestTag: String by inject()
    private lateinit var workObserver: LiveData<List<WorkInfo>>

    override fun fetchData() {
        workManager.beginWith(request).enqueue()
        workObserver = workManager.getWorkInfosByTagLiveData(workRequestTag)
        workObserver.observeForever(this)
    }

    override fun onChanged(worksInfo: List<WorkInfo>) {
        for (workItem in worksInfo) {
            when (workItem.state) {
                WorkInfo.State.ENQUEUED -> Timber.d("Fetch work enqueued")
                WorkInfo.State.RUNNING -> Timber.d("Fetch work is running")
                WorkInfo.State.SUCCEEDED -> {
                    view.onCompleted()
                    clearWork()
                }
                WorkInfo.State.FAILED -> {
                    view.onError(workItem.state.toString())
                    clearWork()

                }
                WorkInfo.State.BLOCKED -> Timber.d("Fetch work is still blocked")
                WorkInfo.State.CANCELLED -> {
                    Timber.d("Fetch work is cancelled")
                    clearWork()
                }
                else -> Timber.d("Fetch work have unknown state")
            }
        }
    }

    private fun clearWork() {
        workManager.pruneWork()
        workObserver.removeObserver(this)
    }
}