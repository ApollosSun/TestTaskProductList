package com.dowell.testtaskproductlist.feature_product.presentation.product_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dowell.testtaskproductlist.feature_product.domain.use_case.GetProductsUseCase
import com.dowell.testtaskproductlist.feature_product.domain.use_case.UpdateProductQuantityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductQuantityUseCase: UpdateProductQuantityUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProductListState(persistentListOf()))
    val state: State<ProductListState> = _state

    private var getProductsJob: Job? = null

    init {
        getProducts()
    }

    fun handleAction(action: ProductListAction) {
        when (action) {
            is ProductListAction.OnIncreaseQuantity -> increaseQuantity(action.productId)
            is ProductListAction.OnDecreaseQuantity -> decreaseQuantity(action.productId)
        }
    }

    private fun getProducts() {
        getProductsJob?.cancel()
        getProductsJob = getProductsUseCase().onEach {
            _state.value = state.value.copy(products = it.toPersistentList())
        }.launchIn(viewModelScope)
    }

    private fun increaseQuantity(productId: Int) {
        viewModelScope.launch {
            state.value.products.firstOrNull { it.id == productId }?.let { product ->
                val newQuantity = product.quantity + 1
                updateProductQuantityUseCase(productId, newQuantity)
            }
        }
    }

    private fun decreaseQuantity(productId: Int) {
        viewModelScope.launch {
            state.value.products.firstOrNull { it.id == productId }?.let { product ->
                val newQuantity = maxOf(0, product.quantity - 1)
                updateProductQuantityUseCase(productId, newQuantity)
            }
        }
    }

}