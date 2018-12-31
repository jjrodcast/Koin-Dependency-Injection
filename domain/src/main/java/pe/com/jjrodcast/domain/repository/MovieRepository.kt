/*
 * Developed by Jorge Rodriguez on 31/12/18 01:08 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 01:08 AM
 */

package pe.com.jjrodcast.domain.repository

import io.reactivex.Observable
import pe.com.jjrodcast.domain.entities.Movie

interface MovieRepository {

    fun getMovies(): Observable<List<Movie>>
}