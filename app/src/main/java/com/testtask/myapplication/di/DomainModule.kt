package com.testtask.myapplication.di

import com.testtask.myapplication.domain.usecases.GetUser
import com.testtask.myapplication.domain.usecases.SaveUser
import org.koin.dsl.module

val domainModule = module {

    single {
        SaveUser(repository = get())
    }

    single {
        GetUser(repository = get())
    }
}