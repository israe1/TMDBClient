package com.example.tmdbclient.data.reprository.movie.dataSource

import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}