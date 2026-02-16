package com.example.tmdbclient.data.reprository.people.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.people.PeopleList
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleRemoteDataSource
import retrofit2.Response

class PeopleRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) : PeopleRemoteDataSource {
    override suspend fun getPeopleFromAPI(): Response<PeopleList> {
        return tmdbService.getPopularPeople(apiKey)
    }
}