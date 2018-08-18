package com.example.kaiyizhang.mykotlin

import android.app.Application
import com.example.kaiyizhang.mykotlin.core.di.ApplicationComponent
import com.example.kaiyizhang.mykotlin.core.di.ApplicationModule
import com.example.kaiyizhang.mykotlin.core.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        this.initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {
    }
}