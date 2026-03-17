package com.example.daggertutorial.uiModels

import com.example.daggertutorial.service.model.Rating


data class ProductModel(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: String,
    val title: String
)