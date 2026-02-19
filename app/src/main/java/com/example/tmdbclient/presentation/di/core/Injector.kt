package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.movie.TvShowSubComponent
import com.example.tmdbclient.presentation.di.people.PeopleSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createPeopleSubComponent(): PeopleSubComponent
}