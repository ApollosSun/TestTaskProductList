package com.dowell.testtaskproductlist.feature_product.domain.use_case

import com.dowell.testtaskproductlist.feature_product.domain.repository.ProductRepository
import javax.inject.Inject

class UpdateProductQuantityUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productId: Int, newQuantity: Int) {
        repository.updateQuantity(productId, newQuantity)
    }
}