package com.example.tmdbclient.domain.tvShow

import com.example.tmdbclient.data.model.tvShow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?

}