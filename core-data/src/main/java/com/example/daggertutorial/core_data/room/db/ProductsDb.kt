package com.example.daggertutorial.core_data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggertutorial.core_data.room.models.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductsDb : RoomDatabase() {

    abstract fun getProductsDao(): ProductDao

}