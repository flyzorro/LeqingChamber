package com.example.kaiyizhang.mykotlin.core.di

import com.example.kaiyizhang.mykotlin.AndroidApplication
import com.example.kaiyizhang.mykotlin.core.di.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
}
