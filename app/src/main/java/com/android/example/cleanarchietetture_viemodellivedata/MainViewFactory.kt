package com.android.example.cleanarchietetture_viemodellivedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewFactory(private val punkService: PunkService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(punkService) as T
        }
        throw IllegalArgumentException("ViewModel unKnow")
    }
}