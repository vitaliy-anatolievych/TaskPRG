package com.testtask.myapplication.app.services

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import com.onesignal.OneSignal
import com.testtask.myapplication.BuildConfig

object RemoteServices {

    fun initAppsFlyerSDK(application: Application) {
        AppsFlyerLib.getInstance().init(BuildConfig.APPS_FLYER_KEY, null, application)
        AppsFlyerLib.getInstance()
            .start(application, BuildConfig.APPS_FLYER_KEY, object : AppsFlyerRequestListener {
                override fun onSuccess() {
                    Log.e("${AppsFlyerLib::class.simpleName}", "Launch successfully")
                }

                override fun onError(errorCode: Int, errorDescription: String) {
                    Log.e("${AppsFlyerLib::class.simpleName}", "$errorCode: $errorDescription")
                }
            })
    }

    fun initOneSignalSDK(application: Application) {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(application)
        OneSignal.setAppId(BuildConfig.ONESIGNAL_APP_ID)
    }

}