package com.dowell.testtaskproductlist.feature_product.presentation.util

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen {

    abstract val route: String
    abstract val fullRoute: String

    data object ProductList : Screen() {
        override val route = "ProductList"
        override val fullRoute = route
    }

    data object ProductDetails : Screen() {
        const val PRODUCT_ID = "productId"
        override val route = "ProductDetails"
        override val fullRoute = "$route/{$PRODUCT_ID}"

        fun getArgs() = listOf(
            navArgument(PRODUCT_ID) {
                type = NavType.IntType
                nullable = false
            }
        )
    }

}