package com.android.example.cleanarchietetture_viemodellivedata

import android.app.Application
import android.util.Log
import com.android.example.cleanarchietetture_viemodellivedata.punkApi.network.PunkProvider

class MyApplication : Application (){

    private val punkProvider = PunkProvider()

    val mainViewModelFactory = MyViewFactory(punkProvider)

    override fun onCreate() {
        super.onCreate()
        Log.d("My application", "Starter")
    }
    }