package com.example.tmdbclient.data.reprository.tvShow.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.tvShow.TvShowList
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvShowRemoteDataSource {
    override suspend fun getTvShowsFromAPI(): Response<TvShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }
}