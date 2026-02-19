package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.reprository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdbclient.data.reprository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleRemoteDataSource
import com.example.tmdbclient.data.reprository.people.dataSourceImpl.PeopleRemoteDataSourceImpl
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providePeopleRemoteDataSource(tmdbService: TMDBService): PeopleRemoteDataSource {
        return PeopleRemoteDataSourceImpl(tmdbService, apiKey)
    }
}