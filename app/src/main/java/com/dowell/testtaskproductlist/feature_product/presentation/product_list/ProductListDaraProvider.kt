package com.dowell.testtaskproductlist.feature_product.presentation.product_list

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.dowell.testtaskproductlist.feature_product.domain.model.Product
import kotlinx.collections.immutable.persistentListOf

class ProductListDaraProvider : PreviewParameterProvider<ProductListState> {
    override val values: Sequence<ProductListState>
        get() = sequenceOf(
            ProductListState(
                persistentListOf(
                    Product(
                        id = 0,
                        name = "Name",
                        description = "Description",
                        price = 10.0,
                        quantity = 5,
                        imageUrl = "https://www.example.com/"
                    )
                )
            )
        )
}