/*
 * Developed by Jorge Rodriguez on 29/12/18 01:10 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 29/12/18 01:09 PM
 */

package pe.com.jjrodcast.koin.view

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.jjrodcast.koin.R
import pe.com.jjrodcast.koin.model.Movie
import pe.com.jjrodcast.koin.view.adapter.MovieAdapter
import pe.com.jjrodcast.koin.view.decorator.CustomDecorator
import pe.com.jjrodcast.koin.viewmodel.MovieViewModel

class MovieActivity : AppCompatActivity(), BaseView {

    private val movieViewModel: MovieViewModel by viewModel()
    private val adapter: MovieAdapter by lazy { MovieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        init()
        observeMovies()
    }

    override fun getContent(): Context = applicationContext

    override fun init() {
        recyclerMovies.itemAnimator = DefaultItemAnimator()
        recyclerMovies.addItemDecoration(CustomDecorator(this, R.integer.offset))
        recyclerMovies.layoutManager = GridLayoutManager(this, 3)
        recyclerMovies.adapter = adapter
    }

    private fun observeMovies() {
        movieViewModel.getMovies().observe(this, Observer<List<Movie>> { movies ->
            adapter.addData(movies as ArrayList<Movie>)
        })
    }
}
