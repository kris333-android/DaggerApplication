package com.example.daggertutorial.core_data.di

import com.example.daggertutorial.core_data.repository.ProductsRepositoryImpl
import com.example.daggertutorial.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindsProductsRepository(repo: ProductsRepositoryImpl): ProductsRepository

}