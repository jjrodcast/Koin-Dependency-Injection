/*
 * Developed by Jorge Rodriguez on 31/12/18 04:05 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 04:03 AM
 */

package pe.com.jjrodcast.data

import io.reactivex.Observable
import pe.com.jjrodcast.domain.entities.Movie
import pe.com.jjrodcast.domain.repository.MovieRepository

class MovieDataRepository : MovieRepository {

    override fun getMovies(): Observable<List<Movie>> {

        val movies = listOf(
            Movie(335983, "Venom", "http://image.tmdb.org/t/p/w300/yIzHw6az7SHEjxaVYy3hMd1Vyc.jpg"),
            Movie(338952, "Animales Fantásticos: Los Crímenes de Grindelwald", "http://image.tmdb.org/t/p/w300/zs6LFuE4aB1I8crKjAhlPVTHAOS.jpg"),
            Movie(346910, "El depredador", "http://image.tmdb.org/t/p/w300/wMq9kQXTeQCHUZOG4fAe5cAxyUA.jpg"),
            Movie(507569, "The Seven Deadly Sins: Prisioneros del Cielo", "http://image.tmdb.org/t/p/w300/r6pPUVUKU5eIpYj4oEzidk5ZibB.jpg"),
            Movie(375588, "Robin Hood", "http://image.tmdb.org/t/p/w300/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"),
            Movie(424694, "Bohemian Rhapsody", "http://image.tmdb.org/t/p/w300/sVmTZxuXhSGYmNL8gbv2XcKTFUy.jpg"),
            Movie(463821, "La Casa del Reloj en la Pared", "http://image.tmdb.org/t/p/w300/3PYx2HvXZuqzVrnfSfbMWoOlloS.jpg"))

        return Observable.just(movies)
    }

}