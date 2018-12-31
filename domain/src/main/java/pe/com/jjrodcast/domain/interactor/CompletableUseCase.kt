/*
 * Developed by Jorge Rodriguez on 31/12/18 01:28 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 01:28 AM
 */

package pe.com.jjrodcast.domain.interactor

import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import pe.com.jjrodcast.domain.executor.PostExecutionThread

abstract class CompletableUseCase<in Params>
    (private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Completable

    open fun execute(observer: DisposableCompletableObserver, params: Params? = null) {
        val completable = buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler())
        addDisposable(completable.subscribeWith(observer))
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

}