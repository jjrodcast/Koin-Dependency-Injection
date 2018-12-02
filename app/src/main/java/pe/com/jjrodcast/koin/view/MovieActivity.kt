package pe.com.jjrodcast.koin.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import pe.com.jjrodcast.koin.R
import pe.com.jjrodcast.koin.model.Movie
import pe.com.jjrodcast.koin.presenter.MoviePresenter
import pe.com.jjrodcast.koin.view.adapter.MovieAdapter
import pe.com.jjrodcast.koin.view.decorator.CustomDecorator

class MovieActivity : AppCompatActivity(), MovieView {

    private val presenter: MoviePresenter by inject { parametersOf(this) }
    private val adapter: MovieAdapter by lazy { MovieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        init()
        presenter.getMovies()
    }

    override fun showMovies(movies: ArrayList<Movie>) {
        adapter.addData(movies)
    }

    override fun getContent(): Context = applicationContext

    override fun init() {
        recyclerMovies.itemAnimator = DefaultItemAnimator()
        recyclerMovies.addItemDecoration(CustomDecorator(this, R.integer.offset))
        recyclerMovies.layoutManager = GridLayoutManager(this, 3)
        recyclerMovies.adapter = adapter
    }
}
