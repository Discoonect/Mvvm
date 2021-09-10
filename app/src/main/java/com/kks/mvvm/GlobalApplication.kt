package com.kks.mvvm

import android.app.Application
import com.kks.mvvm.module.testModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin


class GlobalApplication : Application() {
    companion object {
        private var instance : GlobalApplication? = null

        fun getGlobalApplicationContext(): GlobalApplication? {
            checkNotNull(instance) { "This Application does not inherit com.kakao.GlobalApplication" }
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        startKoin {
            printLogger()
            androidContext(this@GlobalApplication)
            modules(testModule)
        }

    }


    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }
}