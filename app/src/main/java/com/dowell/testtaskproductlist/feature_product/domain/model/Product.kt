package com.dowell.testtaskproductlist.feature_product.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Product(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String
)
