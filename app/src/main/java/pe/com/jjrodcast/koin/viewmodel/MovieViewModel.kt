/*
 * Developed by Jorge Rodriguez on 29/12/18 01:14 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 29/12/18 01:09 PM
 */

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