package com.dowell.testtaskproductlist.feature_product.presentation.product_list

import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import kotlinx.collections.immutable.PersistentList

data class ProductListState(
    val products: PersistentList<Product>
)
