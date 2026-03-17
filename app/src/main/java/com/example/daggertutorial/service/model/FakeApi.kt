package com.example.daggertutorial.service.model

import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductsItem>>
}