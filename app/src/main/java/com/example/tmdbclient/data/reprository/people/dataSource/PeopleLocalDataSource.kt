package com.example.tmdbclient.data.reprository.people.dataSource

import com.example.tmdbclient.data.model.people.People

interface PeopleLocalDataSource {

    suspend fun getPeopleFromDB(): List<People>

    suspend fun savePeopleToDB(people: List<People>)

    suspend fun clearAll()
}