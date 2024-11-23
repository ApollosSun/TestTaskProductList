package com.dowell.testtaskproductlist.feature_product.domain.repository

import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(): Flow<List<Product>>

    suspend fun getProductById(id: Int): Product?

    suspend fun updateQuantity(productId: Int, newQuantity: Int)

}