package com.example.tmdbclient.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.people.GetPeopleUseCase
import com.example.tmdbclient.domain.people.UpdatePeopleUseCase

class PeopleViewModelFactory(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: UpdatePeopleUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PeopleViewModel(getPeopleUseCase, updatePeopleUseCase) as T
    }
}