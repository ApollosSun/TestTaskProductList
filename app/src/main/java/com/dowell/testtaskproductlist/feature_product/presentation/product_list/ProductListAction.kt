package com.dowell.testtaskproductlist.feature_product.presentation.product_list

sealed class ProductListAction {
    data class OnIncreaseQuantity(val productId: Int) : ProductListAction()
    data class OnDecreaseQuantity(val productId: Int) : ProductListAction()
}