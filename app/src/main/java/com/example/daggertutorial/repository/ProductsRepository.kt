package com.example.daggertutorial.repository

import android.util.Log
import com.example.daggertutorial.room.db.ProductsDb
import com.example.daggertutorial.room.models.Product
import com.example.daggertutorial.service.model.FakeApi
import com.example.daggertutorial.uiModels.ProductModel
import retrofit2.Response
import javax.inject.Inject

class ProductsRepository @Inject constructor(val api: FakeApi, val dao: ProductsDb) {

    private val TAG = "ProductsRepository"
    suspend fun getProducts(): List<ProductModel>? {
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
    /*if (resp.isSuccessful) {
        Log.d(TAG, "***** SUCCESS : ${resp}")

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
        return resp.body()?.map {
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
    else {
        dao.getProductsDao().getProducts()
    }*/
}