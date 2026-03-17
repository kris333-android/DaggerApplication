package com.example.daggertutorial.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggertutorial.room.models.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query("SELECT * FROM product")
    suspend fun getProducts(): List<Product>



}