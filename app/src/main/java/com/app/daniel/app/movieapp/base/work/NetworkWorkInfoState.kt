package com.app.daniel.app.movieapp.base.work

import androidx.lifecycle.Observer
import androidx.work.WorkInfo

interface NetworkWorkInfoState : Observer<List<WorkInfo>> {
    override fun onChanged(worksInfo: List<WorkInfo>)
}