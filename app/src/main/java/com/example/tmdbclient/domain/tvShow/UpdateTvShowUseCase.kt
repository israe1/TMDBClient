package com.example.tmdbclient.domain.tvShow

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() = tvShowRepository.updateTvShows()
}