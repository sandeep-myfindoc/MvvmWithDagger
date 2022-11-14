package com.mvvmwithdagger.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvmwithdagger.model.Product
import com.mvvmwithdagger.repositry.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel(){
    val products: LiveData<Product>
    get() = repository.products
    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}