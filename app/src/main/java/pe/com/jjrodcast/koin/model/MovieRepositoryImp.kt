package pe.com.jjrodcast.koin.model

import android.util.Log
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

class MovieRepositoryImp : MovieRepository {

    override fun getRemoteMovies(): ArrayList<Movie> {

        val tempMovies = listOf(
                Movie(335983, "Venom", "http://image.tmdb.org/t/p/w300/yIzHw6az7SHEjxaVYy3hMd1Vyc.jpg"),
                Movie(338952, "Animales Fantásticos: Los Crímenes de Grindelwald", "http://image.tmdb.org/t/p/w300/zs6LFuE4aB1I8crKjAhlPVTHAOS.jpg"),
                Movie(346910, "El depredador", "http://image.tmdb.org/t/p/w300/wMq9kQXTeQCHUZOG4fAe5cAxyUA.jpg"),
                Movie(507569, "The Seven Deadly Sins: Prisioneros del Cielo", "http://image.tmdb.org/t/p/w300/r6pPUVUKU5eIpYj4oEzidk5ZibB.jpg"),
                Movie(375588, "Robin Hood", "http://image.tmdb.org/t/p/w300/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"),
                Movie(424694, "Bohemian Rhapsody", "http://image.tmdb.org/t/p/w300/sVmTZxuXhSGYmNL8gbv2XcKTFUy.jpg"),
                Movie(463821, "La Casa del Reloj en la Pared", "http://image.tmdb.org/t/p/w300/3PYx2HvXZuqzVrnfSfbMWoOlloS.jpg"))

        val movies = arrayListOf<Movie>()

        tempMovies.toObservable()
                .subscribeBy(
                        onNext = { movies.add(it) },
                        onError = { Log.e("MovieRepositoryImp", it.printStackTrace().toString()) },
                        onComplete = { Log.i("MovieRepositoryImp", "onComplete") }
                )

        return movies
    }
}