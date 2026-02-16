package com.example.tmdbclient.data.reprository.people.dataSourceImpl

import com.example.tmdbclient.data.db.PeopleDao
import com.example.tmdbclient.data.model.people.People
import com.example.tmdbclient.data.reprository.people.dataSource.PeopleLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleLocalDataSourceImpl(private val peopleDao: PeopleDao) : PeopleLocalDataSource {
    override suspend fun getPeopleFromDB(): List<People> {
        return peopleDao.getPeople()
    }

    override suspend fun savePeopleToDB(people: List<People>) {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.savePeople(people)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.deleteAllPeople()
        }
    }
}