package com.dowell.testtaskproductlist.feature_product.domain.use_case

import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import com.dowell.testtaskproductlist.feature_product.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(): Flow<List<Product>> {
        return repository.getProducts()
    }

}