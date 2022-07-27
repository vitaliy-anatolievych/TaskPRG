package com.testtask.myapplication.di

import android.content.Context
import android.content.SharedPreferences
import com.testtask.myapplication.BuildConfig
import com.testtask.myapplication.data.local.LocalCache
import com.testtask.myapplication.data.local.LocalCacheImpl
import com.testtask.myapplication.data.repository.CoreRepositoryImpl
import com.testtask.myapplication.domain.repository.CoreRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single<CoreRepository> {
        CoreRepositoryImpl(localCache = get())
    }

    single<LocalCache> {
        LocalCacheImpl(createSharedPreferences(context = androidApplication()))
    }
}

private fun createSharedPreferences(context: Context): SharedPreferences =
    context.getSharedPreferences(BuildConfig.APP_STORAGE, Context.MODE_PRIVATE)
