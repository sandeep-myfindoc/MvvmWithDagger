package com.mvvmwithdagger.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.bumptech.glide.Glide
import com.mvvmwithdagger.R

/*@BindingAdapter ("imageUrl")
fun ImageView.imageFromUrl(url: String){
    Glide.with(this.context).load(url).into(this)
}*/

@BindingAdapter ("imageUrl","placeHolder")
fun ImageView.imageFromUrl(url: String,drawable: Drawable){
    Glide.with(this.context).load(url)
        .placeholder(drawable)
        .into(this)
}
@BindingAdapter("formatDouble")
fun TextView.formatDouble(price: Double){
    Log.e("Price:", price.toString())
    text = price?.toString()
}

/*@BindingAdapter("android:text")
fun TextView.text(price: Double){
    Log.e("Price:", price.toString())
    text = price?.toString()
}*/
