package com.example.tmdbclient.data.reprository.people.dataSource

import com.example.tmdbclient.data.model.people.PeopleList
import retrofit2.Response

interface PeopleRemoteDataSource {

    suspend fun getPeopleFromAPI(): Response<PeopleList>
}