package com.dowell.testtaskproductlist.feature_product.presentation.util

sealed class Screen(val route: String) {
    data object ProductList : Screen("ProductList")
}