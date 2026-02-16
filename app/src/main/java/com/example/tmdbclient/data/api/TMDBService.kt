package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.people.PeopleList
import com.example.tmdbclient.data.model.tvShow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<PeopleList>
}