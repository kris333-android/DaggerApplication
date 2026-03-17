package com.example.daggertutorial.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggertutorial.room.models.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductsDb : RoomDatabase() {

    abstract fun getProductsDao(): ProductDao

}