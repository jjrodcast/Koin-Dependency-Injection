package pe.com.jjrodcast.koin.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pe.com.jjrodcast.koin.model.Movie
import pe.com.jjrodcast.koin.model.MovieRepository

class MovieViewModel(movieRepository: MovieRepository) : ViewModel() {

    private val moviesLiveData = MutableLiveData<List<Movie>>()

    init {
        moviesLiveData.postValue(movieRepository.getRemoteMovies())
    }

    fun getMovies(): LiveData<List<Movie>> = moviesLiveData
}