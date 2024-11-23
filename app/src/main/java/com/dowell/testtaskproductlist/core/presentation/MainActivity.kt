package com.dowell.testtaskproductlist.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.components.ProductListRoute
import com.dowell.testtaskproductlist.feature_product.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.ProductList.route
            ) {
                composable(route = Screen.ProductList.route) {
                    ProductListRoute()
                }
            }
        }
    }

}