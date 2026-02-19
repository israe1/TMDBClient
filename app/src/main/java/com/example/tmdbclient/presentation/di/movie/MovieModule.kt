package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.movie.GetMoviesUseCase
import com.example.tmdbclient.domain.movie.UpdateMovieUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}