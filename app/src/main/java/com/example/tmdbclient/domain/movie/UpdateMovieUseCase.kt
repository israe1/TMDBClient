package com.example.tmdbclient.domain.movie

import com.example.tmdbclient.data.model.movie.Movie

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}