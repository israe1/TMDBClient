package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.movie.MovieRepository

class FakeMovieRepository: MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
        movies.addAll(
            listOf(
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
        )
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.addAll(
            listOf(
                Movie(
                    false,
                    "",
                    4,
                    "en",
                    "originalTitle4",
                    "overview4",
                    2.0,
                    "posterPath4",
                    "date1",
                    "title4",
                    true,
                    1.0,
                    1
                ),
                Movie(
                    false,
                    "",
                    5,
                    "en",
                    "originalTitle5",
                    "overview5",
                    2.0,
                    "posterPath5",
                    "date5",
                    "title5",
                    true,
                    1.0,
                    1
                ),
                Movie(
                    false,
                    "",
                    6,
                    "en",
                    "originalTitle6",
                    "overview6",
                    2.0,
                    "posterPath6",
                    "date6",
                    "title6",
                    true,
                    1.0,
                    1
                )
            )
        )

        return movies
    }
}