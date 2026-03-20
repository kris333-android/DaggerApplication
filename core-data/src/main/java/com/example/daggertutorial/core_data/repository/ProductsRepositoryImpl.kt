package com.example.daggertutorial.core_data.repository

import android.util.Log
import com.example.daggertutorial.core_data.api.FakeApi
import com.example.daggertutorial.core_data.room.db.ProductsDb
import com.example.daggertutorial.core_data.room.models.Product
import com.example.daggertutorial.domain.models.ProductModel
import com.example.daggertutorial.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(val api: FakeApi, val dao: ProductsDb) : ProductsRepository {

    private val TAG = "ProductsRepository"
    override suspend fun getProducts(): List<ProductModel>? {
        try {
            val resp = api.getProducts()

            if (resp.isSuccessful) {
                resp.body()?.let { objList ->
                    dao.getProductsDao().addProducts(
                        objList.map {
                            Product(
                                category = it.category,
                                description = it.description,
                                id = it.id,
                                image = it.image,
                                price = it.price,
                                title = it.title
                            )
                        }
                    )
                }
            }
        } catch (ex: Exception) {
            Log.d(TAG, "getProducts: ERROR CALLING API : ${ex.message}")
            ex.printStackTrace()
        }
        return dao.getProductsDao().getProducts()?.map {
            ProductModel(
                category = it.category,
                description = it.description,
                id = it.id,
                image = it.image,
                price = "$${it.price}",
                title = it.title
            )
        }
    }
}