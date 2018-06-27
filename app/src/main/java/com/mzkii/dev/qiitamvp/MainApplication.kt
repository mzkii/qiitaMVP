package com.mzkii.dev.qiitamvp

import android.app.Application
import com.mzkii.dev.qiitamvp.util.CrashlyticsTree
import timber.log.Timber

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }
}