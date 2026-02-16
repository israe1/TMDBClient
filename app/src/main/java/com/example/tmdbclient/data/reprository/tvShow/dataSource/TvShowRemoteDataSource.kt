package com.example.tmdbclient.data.reprository.tvShow.dataSource

import com.example.tmdbclient.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShowsFromAPI(): Response<TvShowList>
}