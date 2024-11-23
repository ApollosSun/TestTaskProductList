package com.dowell.testtaskproductlist.feature_product.data.repository

import com.dowell.testtaskproductlist.feature_product.data.data_source.ProductDao
import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import com.dowell.testtaskproductlist.feature_product.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val dao: ProductDao
) : ProductRepository {

    override fun getProducts(): Flow<List<Product>> {
        return dao.getProducts()
    }

    override suspend fun getProductById(id: Int): Product? {
        return dao.getProductById(id)
    }

    override suspend fun updateQuantity(productId: Int, newQuantity: Int) {
        dao.updateQuantity(productId, newQuantity)
    }

}