package com.example.daggertutorial.di.module

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.daggertutorial.MainActivity
import com.example.daggertutorial.core_data.di.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.multibindings.ClassKey
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class, DataModule::class]
)
interface ApplicationComponent {
    fun injectMainActivity(mainActivity: MainActivity)

    fun getViewModelMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

}