package com.dowell.testtaskproductlist.feature_product.domain.use_case

import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import com.dowell.testtaskproductlist.feature_product.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(productId: Int): Product? {
        return repository.getProductById(productId)
    }

}