package com.example.daggertutorial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggertutorial.repository.ProductsRepository
import javax.inject.Inject

/*
class MainViewModelFactory @Inject constructor(private val repository: ProductsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository = repository) as T

    }
}*/

class AppViewModelFactory @Inject constructor(private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}