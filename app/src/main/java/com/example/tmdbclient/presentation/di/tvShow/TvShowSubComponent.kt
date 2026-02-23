package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.presentation.di.tvShow.TvShowModule
import com.example.tmdbclient.presentation.di.tvShow.TvShowScope
import com.example.tmdbclient.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}