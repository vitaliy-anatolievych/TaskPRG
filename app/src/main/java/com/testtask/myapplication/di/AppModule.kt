package com.testtask.myapplication.di

import com.testtask.myapplication.presentation.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        AppViewModel()
    }
}