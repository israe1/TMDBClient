package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.PeopleDao
import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.reprository.movie.dataSource.MovieLocalDataSource
import com.example.tmdbclient.data.reprository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleLocalDataSource
import com.example.tmdbclient.data.reprository.people.dataSourceImpl.PeopleLocalDataSourceImpl
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun providePeopleLocalDataSource(peopleDao: PeopleDao): PeopleLocalDataSource {
        return PeopleLocalDataSourceImpl(peopleDao)
    }

}