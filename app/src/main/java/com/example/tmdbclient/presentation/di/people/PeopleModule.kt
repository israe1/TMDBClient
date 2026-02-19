package com.example.tmdbclient.presentation.di.people

import com.example.tmdbclient.domain.people.GetPeopleUseCase
import com.example.tmdbclient.domain.people.UpdatePeopleUseCase
import com.example.tmdbclient.presentation.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PeopleModule {

    @PeopleScope
    @Provides
    fun providesPeopleViewModelFactory(
        getPeopleUseCase: GetPeopleUseCase,
        updatePeopleUseCase: UpdatePeopleUseCase
    ): PeopleViewModelFactory {
        return PeopleViewModelFactory(getPeopleUseCase, updatePeopleUseCase)
    }
}