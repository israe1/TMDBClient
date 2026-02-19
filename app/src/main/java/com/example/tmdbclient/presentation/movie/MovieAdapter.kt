package com.example.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ItemMovieBinding

class MovieAdapter(): RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = arrayListOf<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMovieBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size
}

class MovieViewHolder(val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
        val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.imagePoster.context)
            .load(posterURL)
            .transform(CenterCrop(), RoundedCorners(24))
            .placeholder(R.drawable.search_rounded_background)
            .into(binding.imagePoster)
    }
}