/*
 * Developed by Jorge Rodriguez on 31/12/18 01:32 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 01:32 AM
 */

package pe.com.jjrodcast.domain.interactor.search

import io.reactivex.Observable
import pe.com.jjrodcast.domain.entities.Movie
import pe.com.jjrodcast.domain.executor.PostExecutionThread
import pe.com.jjrodcast.domain.interactor.ObservableUseCase
import pe.com.jjrodcast.domain.repository.MovieRepository

class GetMoviesUseCaseImp(private val movieRepository: MovieRepository,
                          postExecutionThread: PostExecutionThread) :
    ObservableUseCase<List<Movie>, Nothing>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Movie>> {
        return movieRepository.getMovies()
    }
}