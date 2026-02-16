package com.example.tmdbclient.data.reprository.people.dataSourceImpl

import com.example.tmdbclient.data.model.people.People
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleCacheDataSource

class PeopleCacheDataSourceImpl : PeopleCacheDataSource {
    private val peopleList = ArrayList<People>()

    override suspend fun getPeopleFromCache(): List<People> {
        return peopleList
    }

    override suspend fun savePeopleToCache(people: List<People>) {
        peopleList.clear()
        peopleList.addAll(people)
    }
}