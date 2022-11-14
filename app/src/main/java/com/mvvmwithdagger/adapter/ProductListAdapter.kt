package com.mvvmwithdagger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.mvvmwithdagger.databinding.SubitemProductBinding
import com.mvvmwithdagger.model.Product
import com.mvvmwithdagger.model.ProductItem

class ProductListAdapter(val productData: List<ProductItem>): RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = SubitemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.ref = productData[position]
    }

    override fun getItemCount(): Int {
        return productData.size
    }

    inner class ProductViewHolder(val binding: SubitemProductBinding): RecyclerView.ViewHolder(binding.root){

    }
}