package com.example.tmdbclient.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.people.People
import com.example.tmdbclient.data.model.tvShow.TvShow
import com.example.tmdbclient.data.model.movie.Movie

@Database(entities = [Movie::class, TvShow::class, People::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun peopleDao(): PeopleDao

    companion object {
        @Volatile
        private var INSTANCE: TMDBDatabase? = null
        fun getInstance(context: Context): TMDBDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TMDBDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}