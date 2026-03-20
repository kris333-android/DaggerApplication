package com.example.daggertutorial.core_data.api

import com.example.daggertutorial.core_data.api.model.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductsItem>>
}