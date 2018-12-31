/*
 * Developed by Jorge Rodriguez on 29/12/18 01:04 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 26/12/18 09:31 PM
 */

package pe.com.jjrodcast.koin.presenter

import io.reactivex.observers.DisposableObserver
import pe.com.jjrodcast.domain.entities.Movie
import pe.com.jjrodcast.domain.interactor.ObservableUseCase
import pe.com.jjrodcast.koin.mapper.Mapper
import pe.com.jjrodcast.koin.model.MovieEntity
import pe.com.jjrodcast.koin.view.MovieView

class MoviePresenterImp(
    val mapper: Mapper<Movie, MovieEntity>,
    val view: MovieView,
    private val moviesUseCaseImp: ObservableUseCase<List<Movie>, Nothing>
) : MoviePresenter {

    override fun getMovies() {
        moviesUseCaseImp.execute(object : DisposableObserver<List<Movie>>() {
            override fun onComplete() = Unit
            override fun onError(e: Throwable) {}
            override fun onNext(movies: List<Movie>) {
                view.showMovies(mapper.mapList(movies) as ArrayList<MovieEntity>)
            }
        })
    }

    override fun onDestroy() {
        moviesUseCaseImp.dispose()
    }

}