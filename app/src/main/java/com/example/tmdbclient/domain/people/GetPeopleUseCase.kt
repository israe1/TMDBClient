package com.example.tmdbclient.domain.people

class GetPeopleUseCase(private val peopleRepository: PeopleRepository) {

    suspend fun execute() = peopleRepository.getPeople()
}