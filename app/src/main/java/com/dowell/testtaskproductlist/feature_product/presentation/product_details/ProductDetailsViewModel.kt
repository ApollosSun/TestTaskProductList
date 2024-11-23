package com.dowell.testtaskproductlist.feature_product.presentation.product_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dowell.testtaskproductlist.feature_product.domain.use_case.GetProductByIdUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ProductDetailsViewModel.Factory::class)
class ProductDetailsViewModel @AssistedInject constructor(
    @Assisted private val productId: Int,
    private val getProductByIdUseCase: GetProductByIdUseCase
) : ViewModel() {

    private val _state = mutableStateOf<ProductDetailsState?>(null)
    val state: State<ProductDetailsState?> = _state

    init {
        getProductById()
    }

    private fun getProductById() {
        viewModelScope.launch(Dispatchers.IO) {
            getProductByIdUseCase(productId)?.let { product ->
                _state.value =
                    state.value?.copy(product = product) ?: ProductDetailsState(product = product)
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(productId: Int): ProductDetailsViewModel
    }

}