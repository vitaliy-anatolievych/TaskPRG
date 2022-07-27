package com.testtask.myapplication.app

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import com.onesignal.OneSignal
import com.testtask.myapplication.BuildConfig
import com.testtask.myapplication.app.services.RemoteServices
import com.testtask.myapplication.di.appModule
import com.testtask.myapplication.di.dataModule
import com.testtask.myapplication.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(
                appModule,
                domainModule,
                dataModule
            ))
        }

        RemoteServices.initAppsFlyerSDK(this)
        RemoteServices.initOneSignalSDK(this)
    }
}