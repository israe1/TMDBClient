package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.movie.GetMoviesUseCase
import com.example.tmdbclient.domain.movie.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMovieUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val list = getMoviesUseCase.execute()
        emit(list)
    }

    fun updateMovies() = liveData {
        val list = updateMoviesUseCase.execute()
        emit(list)
    }
}