package com.example.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var doa: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        doa = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = getDummyMovies()
        doa.saveMovies(movies)

        val allMovies = doa.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteAllMoviesTest() = runBlocking {
        doa.saveMovies(getDummyMovies())
        doa.deleteAllMovies()

        val allMovies = doa.getMovies()
        Truth.assertThat(allMovies).isEmpty()
    }

    private fun getDummyMovies(): List<Movie> {
        return listOf(
            Movie(
                false,
                "",
                1,
                "en",
                "originalTitle1",
                "overview1",
                2.0,
                "posterPath1",
                "date1",
                "title1",
                true,
                1.0,
                1
            ),
            Movie(
                false,
                "",
                2,
                "en",
                "originalTitle2",
                "overview2",
                2.0,
                "posterPath2",
                "date2",
                "title2",
                true,
                1.0,
                1
            ),
            Movie(
                false,
                "",
                3,
                "en",
                "originalTitle3",
                "overview3",
                2.0,
                "posterPath3",
                "date3",
                "title3",
                true,
                1.0,
                1
            )
        )
    }
}