package pe.com.jjrodcast.koin.presenter

import pe.com.jjrodcast.koin.model.MovieInteractor
import pe.com.jjrodcast.koin.view.MovieView

class MoviePresenterImp(val view: MovieView, private val interactor: MovieInteractor) : MoviePresenter {

    override fun getMovies() {
        val movies = interactor.getRemoteMovies()
        view.showMovies(movies)
    }

}