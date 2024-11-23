@file:OptIn(ExperimentalMaterial3Api::class)

package com.dowell.testtaskproductlist.feature_product.presentation.product_details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import com.dowell.testtaskproductlist.feature_product.presentation.product_details.ProductDetailsViewModel
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.components.ProductItem

@Composable
fun ProductDetailsRoute(
    viewModel: ProductDetailsViewModel,
    onBackPressed: () -> Unit
) {
    val uiState by viewModel.state

    uiState?.product?.let { product ->
        ProductDetailsCScreen(
            product = product,
            onBackPressed = onBackPressed
        )
    }
}

@Composable
private fun ProductDetailsCScreen(
    product: Product,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Product Details"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            // Fot simplicity ProductItem was reused.
            ProductItem(
                item = product,
                handleAction = {}
            )
        }
    }
}