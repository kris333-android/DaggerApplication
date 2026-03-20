package com.example.daggertutorial.domain.usecases

import com.example.daggertutorial.domain.models.ProductModel
import com.example.daggertutorial.domain.repository.ProductsRepository
import javax.inject.Inject

data class GetProductsUseCase @Inject constructor(private val repository: ProductsRepository) {
    suspend operator fun invoke(): List<ProductModel>? {
        return repository.getProducts()
    }
}
