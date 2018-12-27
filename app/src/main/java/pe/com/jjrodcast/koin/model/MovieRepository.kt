package pe.com.jjrodcast.koin.model

interface MovieRepository {

    fun getRemoteMovies(): ArrayList<Movie>
}