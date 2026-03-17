package com.example.daggertutorial.di.module

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.daggertutorial.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.multibindings.ClassKey
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun injectMainActivity(mainActivity: MainActivity)

    fun getViewModelMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

}