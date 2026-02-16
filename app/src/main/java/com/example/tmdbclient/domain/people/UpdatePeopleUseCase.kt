package com.example.tmdbclient.domain.people

class UpdatePeopleUseCase(private val peopleRepository: PeopleRepository) {

    suspend fun execute() = peopleRepository.updatePeople()
}