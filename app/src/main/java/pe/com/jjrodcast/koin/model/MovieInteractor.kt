package pe.com.jjrodcast.koin.model

interface MovieInteractor {

    fun getRemoteMovies(): ArrayList<Movie>
}