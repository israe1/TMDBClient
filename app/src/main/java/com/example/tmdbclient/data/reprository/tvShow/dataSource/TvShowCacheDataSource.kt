package com.example.tmdbclient.data.reprository.tvShow.dataSource

import com.example.tmdbclient.data.model.tvShow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}