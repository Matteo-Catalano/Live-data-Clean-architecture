package com.android.example.cleanarchietetture_viemodellivedata

import android.app.Application
import android.util.Log

class MyApplication : Application (){

    private val punkProvider = PunkProvider()

    val mainViewModelFactory = MainViewFactory(punkProvider.provide())

    override fun onCreate() {
        super.onCreate()
        Log.d("My application", "Starter")
    }
    }