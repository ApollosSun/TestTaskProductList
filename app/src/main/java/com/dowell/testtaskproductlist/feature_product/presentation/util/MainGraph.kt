package com.dowell.testtaskproductlist.feature_product.presentation.util

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dowell.testtaskproductlist.feature_product.presentation.product_details.ProductDetailsViewModel
import com.dowell.testtaskproductlist.feature_product.presentation.product_details.components.ProductDetailsRoute
import com.dowell.testtaskproductlist.feature_product.presentation.product_details.navigation.navigateToProductDetails
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.components.ProductListRoute

fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable(route = Screen.ProductList.fullRoute) {
        ProductListRoute(
            navigateToProductDetails = navController::navigateToProductDetails
        )
    }
    composable(
        route = Screen.ProductDetails.fullRoute,
        arguments = Screen.ProductDetails.getArgs()
    ) { backStack ->
        val productId = backStack.arguments?.getInt(Screen.ProductDetails.PRODUCT_ID)
            ?: throw IllegalArgumentException("Product id can't be null.")

        ProductDetailsRoute(
            viewModel = hiltViewModel { factory: ProductDetailsViewModel.Factory ->
                factory.create(productId = productId)
            },
            onBackPressed = navController::navigateUp
        )
    }
}