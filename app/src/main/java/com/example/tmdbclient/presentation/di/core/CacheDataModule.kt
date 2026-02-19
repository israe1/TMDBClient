package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.reprository.movie.dataSource.MovieCacheDataSource
import com.example.tmdbclient.data.reprository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleCacheDataSource
import com.example.tmdbclient.data.reprository.people.dataSourceImpl.PeopleCacheDataSourceImpl
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providePeopleCacheDataSource(): PeopleCacheDataSource {
        return PeopleCacheDataSourceImpl()
    }
}