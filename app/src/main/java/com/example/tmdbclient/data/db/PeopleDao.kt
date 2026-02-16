package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.people.People

@Dao
interface PeopleDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun savePeople(people: List<People>)

    @Query("SELECT * FROM popular_people")
    suspend fun getPeople(): List<People>

    @Query("DELETE FROM popular_people")
    suspend fun deleteAllPeople()
}