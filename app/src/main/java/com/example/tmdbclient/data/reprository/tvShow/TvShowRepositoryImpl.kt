package com.example.tmdbclient.data.reprository.tvShow

import android.util.Log
import com.example.tmdbclient.data.model.tvShow.TvShow
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.tvShow.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfPeople = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfPeople)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfPeople)
        return newListOfPeople
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShowsFromAPI()
            val body = response.body()
            if (body != null) tvShowList = body.tvShows
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}