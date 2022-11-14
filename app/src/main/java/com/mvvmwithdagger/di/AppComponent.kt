package com.mvvmwithdagger.di

import com.mvvmwithdagger.view.MainActivity
import dagger.Component

@Component (modules = [NetworkModule::class])
interface AppComponent {
    fun init(mainActivity: MainActivity)
}