package com.example.tmdbclient.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.tvShow.GetTvShowsUseCase
import com.example.tmdbclient.domain.tvShow.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val list = getTvShowsUseCase.execute()
        emit(list)
    }

    fun updateTvShowa() = liveData {
        val list = updateTvShowsUseCase.execute()
        emit(list)
    }

}