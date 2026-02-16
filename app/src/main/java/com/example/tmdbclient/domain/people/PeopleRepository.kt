package com.example.tmdbclient.domain.people

import com.example.tmdbclient.data.model.people.People

interface PeopleRepository {

    suspend fun getPeople(): List<People>?

    suspend fun updatePeople(): List<People>?

}