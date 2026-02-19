package com.example.tmdbclient.presentation.di.tvShow;

import com.example.tmdbclient.domain.tvShow.GetTvShowsUseCase;
import com.example.tmdbclient.domain.tvShow.UpdateTvShowUseCase;
import com.example.tmdbclient.presentation.di.tvshow.TvShowScope;
import com.example.tmdbclient.presentation.tvShow.TvShowViewModelFactory

import dagger.Module;
import dagger.Provides;

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}
