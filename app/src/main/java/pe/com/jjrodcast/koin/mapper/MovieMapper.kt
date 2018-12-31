/*
 * Developed by Jorge Rodriguez on 31/12/18 02:29 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 02:29 AM
 */

package pe.com.jjrodcast.koin.mapper

import pe.com.jjrodcast.domain.entities.Movie
import pe.com.jjrodcast.koin.model.MovieEntity

class MovieMapper : Mapper<Movie, MovieEntity> {

    override fun map(from: Movie): MovieEntity {
        return MovieEntity(
            id = from.id,
            name = from.name,
            photo = from.photo
        )
    }

    override fun mapList(from: List<Movie>): List<MovieEntity> {
        val moviesList = arrayListOf<MovieEntity>()
        for (movie in from) {
            moviesList.add(map(movie))
        }

        return moviesList
    }
}