/*
 * Developed by Jorge Rodriguez on 31/12/18 03:18 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 03:18 AM
 */

package pe.com.jjrodcast.koin.view

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import pe.com.jjrodcast.domain.executor.PostExecutionThread

class MainThread : PostExecutionThread {

    override fun scheduler(): Scheduler = AndroidSchedulers.mainThread()
}