package com.example.tmdbclient.data.reprository.people.dataSource

import com.example.tmdbclient.data.model.people.People

interface PeopleCacheDataSource {

    suspend fun getPeopleFromCache(): List<People>

    suspend fun savePeopleToCache(people: List<People>)
}