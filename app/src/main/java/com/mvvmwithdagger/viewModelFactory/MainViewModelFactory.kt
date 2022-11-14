package com.mvvmwithdagger.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvmwithdagger.repositry.ProductRepository
import com.mvvmwithdagger.viewModel.MainViewModel
import javax.inject.Inject

class MainViewModelFactory@Inject constructor(private val repository: ProductRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}