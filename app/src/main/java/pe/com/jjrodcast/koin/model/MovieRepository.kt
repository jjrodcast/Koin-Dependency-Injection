/*
 * Developed by Jorge Rodriguez on 29/12/18 01:09 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 29/12/18 01:09 PM
 */

package pe.com.jjrodcast.koin.model

interface MovieRepository {

    fun getRemoteMovies(): ArrayList<Movie>
}