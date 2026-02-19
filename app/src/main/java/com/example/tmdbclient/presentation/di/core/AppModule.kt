package com.example.tmdbclient.presentation.di.core

import android.content.Context
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.movie.TvShowSubComponent
import com.example.tmdbclient.presentation.di.people.PeopleSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    PeopleSubComponent::class]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}