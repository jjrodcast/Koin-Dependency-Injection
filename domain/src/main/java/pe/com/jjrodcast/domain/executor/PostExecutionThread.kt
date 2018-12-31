/*
 * Developed by Jorge Rodriguez on 31/12/18 01:12 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 01:12 AM
 */

package pe.com.jjrodcast.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {

    fun scheduler(): Scheduler
}