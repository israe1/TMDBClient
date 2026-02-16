package com.example.tmdbclient.domain.tvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() = tvShowRepository.getTvShows()

}