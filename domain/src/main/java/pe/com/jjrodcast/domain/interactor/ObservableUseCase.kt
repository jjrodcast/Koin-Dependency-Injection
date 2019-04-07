/*
 * Developed by Jorge Rodriguez on 31/12/18 01:15 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 01:15 AM
 */

package pe.com.jjrodcast.domain.interactor

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import pe.com.jjrodcast.domain.executor.PostExecutionThread

abstract class ObservableUseCase<T, in Params>
    (private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params? = null) {
        val singleThread = buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler())
        addDisposable(singleThread.subscribeWith(observer))
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

}