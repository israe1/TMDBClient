package com.example.tmdbclient.data.reprository.movie.dataSource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMovieFromDB(): List<Movie>

    suspend fun saveMovies(movies: List<Movie>)

    suspend fun clearAll()
}