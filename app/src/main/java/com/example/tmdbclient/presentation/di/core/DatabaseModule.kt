package com.example.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.tvShowDao()

    @Singleton
    @Provides
    fun providePeopleDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.peopleDao()
}