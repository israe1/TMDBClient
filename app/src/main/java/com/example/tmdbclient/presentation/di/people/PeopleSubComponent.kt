package com.example.tmdbclient.presentation.di.people

import com.example.tmdbclient.presentation.people.PeopleActivity
import dagger.Subcomponent

@PeopleScope
@Subcomponent(modules = [PeopleModule::class])
interface PeopleSubComponent {

    fun inject(peopleActivity: PeopleActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PeopleSubComponent
    }
}