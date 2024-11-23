package com.dowell.testtaskproductlist.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dowell.testtaskproductlist.feature_product.presentation.util.Screen
import com.dowell.testtaskproductlist.feature_product.presentation.util.mainGraph
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
                mainGraph(navController = navController)
            }
        }
    }

}