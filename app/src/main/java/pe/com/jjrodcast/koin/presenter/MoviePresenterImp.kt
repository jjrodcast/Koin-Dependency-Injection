/*
 * Developed by Jorge Rodriguez on 29/12/18 01:04 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 26/12/18 09:31 PM
 */

package pe.com.jjrodcast.koin.presenter

import pe.com.jjrodcast.koin.model.MovieInteractor
import pe.com.jjrodcast.koin.view.MovieView

class MoviePresenterImp(val view: MovieView, private val interactor: MovieInteractor) : MoviePresenter {

    override fun getMovies() {
        val movies = interactor.getRemoteMovies()
        view.showMovies(movies)
    }

}