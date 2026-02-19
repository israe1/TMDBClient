package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.movie.GetMoviesUseCase
import com.example.tmdbclient.domain.movie.MovieRepository
import com.example.tmdbclient.domain.movie.UpdateMovieUseCase
import com.example.tmdbclient.domain.people.GetPeopleUseCase
import com.example.tmdbclient.domain.people.PeopleRepository
import com.example.tmdbclient.domain.people.UpdatePeopleUseCase
import com.example.tmdbclient.domain.tvShow.GetTvShowsUseCase
import com.example.tmdbclient.domain.tvShow.TvShowRepository
import com.example.tmdbclient.domain.tvShow.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideGetPeopleUseCase(peopleRepository: PeopleRepository): GetPeopleUseCase {
        return GetPeopleUseCase(peopleRepository)
    }

    @Singleton
    @Provides
    fun provideUpdatePeopleUseCase(peopleRepository: PeopleRepository): UpdatePeopleUseCase {
        return UpdatePeopleUseCase(peopleRepository)
    }

}