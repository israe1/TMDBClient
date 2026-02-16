package com.example.tmdbclient.data.reprository.tvShow.dataSourceImpl

import com.example.tmdbclient.data.model.tvShow.TvShow
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private val tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
}