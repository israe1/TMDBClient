package com.example.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.FakeMovieRepository
import com.example.tmdbclient.domain.movie.GetMoviesUseCase
import com.example.tmdbclient.domain.movie.UpdateMovieUseCase
import com.example.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMovieUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMovieUseCase, updateMovieUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
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

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        val movies = mutableListOf<Movie>()
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

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}