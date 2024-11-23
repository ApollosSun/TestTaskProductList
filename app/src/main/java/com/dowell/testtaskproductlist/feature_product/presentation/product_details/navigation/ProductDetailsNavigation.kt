package com.dowell.testtaskproductlist.feature_product.presentation.product_details.navigation

import androidx.navigation.NavController
import com.dowell.testtaskproductlist.feature_product.presentation.util.Screen

fun NavController.navigateToProductDetails(productId: Int) {
    navigate("${Screen.ProductDetails.route}/$productId")
}