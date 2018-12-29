/*
 * Developed by Jorge Rodriguez on 29/12/18 01:05 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 01/12/18 09:47 PM
 */

package pe.com.jjrodcast.koin.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_movie.view.*
import pe.com.jjrodcast.koin.R
import pe.com.jjrodcast.koin.model.Movie
import pe.com.jjrodcast.koin.utils.GlideApp

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val movies = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun addData(movies: ArrayList<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie) = with(itemView) {
            GlideApp.with(itemView.context)
                .load(movie.photo)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(movie_photo)
        }
    }
}