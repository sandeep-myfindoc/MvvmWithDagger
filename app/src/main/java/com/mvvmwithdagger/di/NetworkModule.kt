package com.mvvmwithdagger.di

import com.mvvmwithdagger.retrofit.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideApi(): ApiService{
        val builder = Retrofit.Builder()
        builder.baseUrl("https://fakestoreapi.com/")
        builder.addConverterFactory(GsonConverterFactory.create())
        //builder.client()- use it to add okhttpclient (for caching,setting header or pass token)
        return builder.build().create(ApiService::class.java)
    }
}