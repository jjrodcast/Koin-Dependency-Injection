package pe.com.jjrodcast.koin.view

import pe.com.jjrodcast.koin.model.Movie

interface MovieView : BaseView {

    fun showMovies(movies: ArrayList<Movie>)
}