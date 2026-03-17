package com.example.daggertutorial.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.daggertutorial.service.model.Rating

@Entity
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)