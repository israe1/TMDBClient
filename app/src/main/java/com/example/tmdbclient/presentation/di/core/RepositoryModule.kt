package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.reprository.movie.MovieRepositoryImpl
import com.example.tmdbclient.data.reprository.movie.dataSource.MovieCacheDataSource
import com.example.tmdbclient.data.reprository.movie.dataSource.MovieLocalDataSource
import com.example.tmdbclient.data.reprository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdbclient.data.reprository.people.PeopleRepositoryImpl
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleCacheDataSource
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleLocalDataSource
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleRemoteDataSource
import com.example.tmdbclient.data.reprository.tvShow.TvShowRepositoryImpl
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdbclient.data.reprository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.movie.MovieRepository
import com.example.tmdbclient.domain.people.PeopleRepository
import com.example.tmdbclient.domain.tvShow.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providePeopleRepository(
        peopleRemoteDataSource: PeopleRemoteDataSource,
        peopleLocalDataSource: PeopleLocalDataSource,
        peopleCacheDataSource: PeopleCacheDataSource
    ): PeopleRepository {
        return PeopleRepositoryImpl(
            peopleRemoteDataSource,
            peopleLocalDataSource,
            peopleCacheDataSource
        )
    }

}