package com.example.daggertutorial.core_data.api.model

import com.example.daggertutorial.core_data.api.model.Rating

data class ProductsItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)