package com.example.daggertutorial.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggertutorial.repository.ProductsRepository
import com.example.daggertutorial.uiModels.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {

    private val TAG = "MainViewModel"
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            Log.d(TAG, "***** CALLED getProducts: ")
            val response = repository.getProducts()
            if (!response.isNullOrEmpty()) {
                _uiState.value = MainUiState(
                    isLoading = false, isError = false, products = response
                )
            } else {
                _uiState.value = MainUiState(
                    isLoading = false, isError = false, products = emptyList<ProductModel>()
                )
            }
        }

    }
}

data class MainUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val products: List<ProductModel> = emptyList()
)
