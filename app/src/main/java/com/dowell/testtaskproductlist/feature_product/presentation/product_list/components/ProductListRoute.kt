@file:OptIn(ExperimentalMaterial3Api::class)

package com.dowell.testtaskproductlist.feature_product.presentation.product_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dowell.testtaskproductlist.core.presentation.components.ItemDivider
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListAction
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListDaraProvider
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListState
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListViewModel

@Composable
fun ProductListRoute(
    viewModel: ProductListViewModel = hiltViewModel(),
    navigateToProductDetails: (Int) -> Unit
) {
    val uiState by viewModel.state

    ProductListScreen(
        uiState = uiState,
        handleAction = viewModel::handleAction,
        navigateToProductDetails = navigateToProductDetails
    )
}

@Composable
private fun ProductListScreen(
    uiState: ProductListState,
    handleAction: (ProductListAction) -> Unit,
    navigateToProductDetails: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Your Products"
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 15.dp)
        ) {
            LazyColumn {
                items(uiState.products, key = { item -> item.id }) { item ->
                    ProductItem(
                        modifier = Modifier.clickable { navigateToProductDetails(item.id) },
                        item = item,
                        handleAction = handleAction
                    )
                    ItemDivider()
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(@PreviewParameter(ProductListDaraProvider::class) uiState: ProductListState) {
    ProductListScreen(
        uiState = uiState,
        handleAction = {},
        navigateToProductDetails = {}
    )
}