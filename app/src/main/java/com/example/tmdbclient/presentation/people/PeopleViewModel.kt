package com.example.tmdbclient.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.people.GetPeopleUseCase
import com.example.tmdbclient.domain.people.UpdatePeopleUseCase

class PeopleViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: UpdatePeopleUseCase
): ViewModel() {

    fun getPeople() = liveData {
        val list = getPeopleUseCase.execute()
        emit(list)
    }

    fun updatePeople() = liveData {
        val list = updatePeopleUseCase.execute()
        emit(list)
    }
}