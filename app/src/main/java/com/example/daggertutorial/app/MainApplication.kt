package com.example.daggertutorial.app

import android.app.Application
import com.example.daggertutorial.di.module.ApplicationComponent
import com.example.daggertutorial.di.module.DaggerApplicationComponent

class MainApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}