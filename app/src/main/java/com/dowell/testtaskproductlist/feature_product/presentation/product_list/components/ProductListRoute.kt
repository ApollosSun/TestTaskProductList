package com.dowell.testtaskproductlist.feature_product.presentation.product_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dowell.testtaskproductlist.core.presentation.components.ItemDivider
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListAction
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListDaraProvider
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListState
import com.dowell.testtaskproductlist.feature_product.presentation.product_list.ProductListViewModel

@Composable
fun ProductListRoute(
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val uiState by viewModel.state

    ProductListScreen(
        uiState = uiState,
        handleAction = viewModel::handleAction
    )
}

@Composable
private fun ProductListScreen(
    uiState: ProductListState,
    handleAction: (ProductListAction) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(top = 15.dp)
    ) {
        Text(
            text = "Your Products",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        LazyColumn {
            items(uiState.products, key = { item -> item.id }) { item ->
                ProductItem(
                    item = item,
                    handleAction = handleAction
                )
                ItemDivider()
            }
        }
    }
}

@Preview
@Composable
private fun Preview(@PreviewParameter(ProductListDaraProvider::class) uiState: ProductListState) {
    ProductListScreen(
        uiState = uiState,
        handleAction = {}
    )
}