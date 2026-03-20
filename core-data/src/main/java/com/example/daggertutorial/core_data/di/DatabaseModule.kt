package com.example.daggertutorial.core_data.di

import android.content.Context
import androidx.room.Room
import com.example.daggertutorial.core_data.room.db.ProductsDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ProductsDb {
        return Room.databaseBuilder(
            context,
            ProductsDb::class.java,
            "products_db"
        ).build()
    }
}
