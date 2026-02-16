package com.example.tmdbclient.data.reprository.people

import android.util.Log
import com.example.tmdbclient.data.model.people.People
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleCacheDataSource
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleLocalDataSource
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleRemoteDataSource
import com.example.tmdbclient.domain.people.PeopleRepository

class PeopleRepositoryImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource,
    private val peopleLocalDataSource: PeopleLocalDataSource,
    private val peopleCacheDataSource: PeopleCacheDataSource
): PeopleRepository {

    override suspend fun getPeople(): List<People>? {
        return getPeopleFromCache()
    }

    override suspend fun updatePeople(): List<People>? {
        val newListOfPeople = getPeopleFromAPI()
        peopleLocalDataSource.clearAll()
        peopleLocalDataSource.savePeopleToDB(newListOfPeople)
        peopleCacheDataSource.savePeopleToCache(newListOfPeople)
        return newListOfPeople
    }

    suspend fun getPeopleFromAPI(): List<People> {
        lateinit var peopleList: List<People>

        try {
            val response = peopleRemoteDataSource.getPeopleFromAPI()
            val body = response.body()
            if (body != null) peopleList = body.people
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        return peopleList
    }

    suspend fun getPeopleFromDB(): List<People> {
        lateinit var peopleList: List<People>

        try {
            peopleList = peopleLocalDataSource.getPeopleFromDB()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (peopleList.isEmpty()) {
            peopleList = getPeopleFromAPI()
            peopleLocalDataSource.savePeopleToDB(peopleList)
        }
        return peopleList
    }

    suspend fun getPeopleFromCache(): List<People> {
        lateinit var peopleList: List<People>

        try {
            peopleList = peopleCacheDataSource.getPeopleFromCache()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (peopleList.isEmpty()) {
            peopleList = getPeopleFromDB()
            peopleCacheDataSource.savePeopleToCache(peopleList)
        }
        return peopleList
    }
}