package com.example.tmdbclient.data.reprository.movie.dataSourceImpl

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.reprository.movie.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private val movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}