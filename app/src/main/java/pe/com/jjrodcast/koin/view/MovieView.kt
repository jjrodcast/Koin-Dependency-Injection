/*
 * Developed by Jorge Rodriguez on 29/12/18 01:05 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 26/12/18 09:31 PM
 */

package pe.com.jjrodcast.koin.view

import pe.com.jjrodcast.koin.model.Movie

interface MovieView : BaseView {

    fun showMovies(movies: ArrayList<Movie>)
}