package com.mvvmwithdagger.repositry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvmwithdagger.model.Product
import com.mvvmwithdagger.retrofit.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) {
    private val _products = MutableLiveData<Product>()
    val products: LiveData<Product>
    get() = _products
    suspend fun getProducts(){
        val result = apiService.getProducts()
        if(result.isSuccessful && result.body()!=null){
            _products.postValue(result.body())
        }
    }
}