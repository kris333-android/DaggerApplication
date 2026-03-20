package com.example.daggertutorial.domain.repository

import com.example.daggertutorial.domain.models.ProductModel

interface ProductsRepository {
    suspend fun getProducts(): List<ProductModel>?
}