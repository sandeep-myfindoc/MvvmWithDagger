package com.mvvmwithdagger.retrofit

import com.mvvmwithdagger.model.Product
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET


// define the service here that you want to call
interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<Product>
}
/*
* There are three way to pass Header
* 1) Using Header annotaion along @GET or @POSt Annotation. we use it to pass static values in header
* 2) Pass Header inside the function call
* 3) to pass dynamic header we use intercept
* */