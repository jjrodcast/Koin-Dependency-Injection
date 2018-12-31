/*
 * Developed by Jorge Rodriguez on 29/12/18 01:04 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 26/12/18 09:31 PM
 */

package pe.com.jjrodcast.koin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import pe.com.jjrodcast.data.MovieDataRepository
import pe.com.jjrodcast.domain.entities.Movie
import pe.com.jjrodcast.domain.executor.PostExecutionThread
import pe.com.jjrodcast.domain.interactor.ObservableUseCase
import pe.com.jjrodcast.domain.interactor.search.GetMoviesUseCaseImp
import pe.com.jjrodcast.domain.repository.MovieRepository
import pe.com.jjrodcast.koin.mapper.Mapper
import pe.com.jjrodcast.koin.mapper.MovieMapper
import pe.com.jjrodcast.koin.model.MovieEntity
import pe.com.jjrodcast.koin.presenter.MoviePresenter
import pe.com.jjrodcast.koin.presenter.MoviePresenterImp
import pe.com.jjrodcast.koin.view.MainThread
import pe.com.jjrodcast.koin.view.MovieView

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

    private val appModule = module {
        factory<Mapper<Movie, MovieEntity>> { MovieMapper() }
        single<MovieRepository> { MovieDataRepository() }
        single<PostExecutionThread> { MainThread() }
        single<ObservableUseCase<List<Movie>, Nothing>> { GetMoviesUseCaseImp(get(), get()) }
        factory<MoviePresenter> { (view: MovieView) -> MoviePresenterImp(get(), view, get()) }
    }


}