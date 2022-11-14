package com.mvvmwithdagger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvmwithdagger.R
import com.mvvmwithdagger.adapter.ProductListAdapter
import com.mvvmwithdagger.databinding.ActivityMainBinding
import com.mvvmwithdagger.di.DaggerAppComponent
import com.mvvmwithdagger.viewModel.MainViewModel
import com.mvvmwithdagger.viewModelFactory.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ProductListAdapter
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    @Inject // property injection- do not support injection to private property
    lateinit var viewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.rvProductList.layoutManager = LinearLayoutManager(this)
        val appComponent = DaggerAppComponent.builder().build()
        appComponent.init(this)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.products.observe(this, Observer {
            Log.e("Size: ",it.size.toString())
            adapter = ProductListAdapter(it)
            binding.rvProductList.adapter = adapter
            for(item in it){
                Log.e("product is: ",item.toString())
            }
        })
    }
}