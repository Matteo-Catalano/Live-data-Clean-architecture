package com.android.example.cleanarchietetture_viemodellivedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.cleanarchietetture_viemodellivedata.punkApi.network.PunkProvider
import com.android.example.cleanarchietetture_viemodellivedata.punkApi.usacase.PunkSearchViewModel
import java.lang.IllegalArgumentException

class MyViewFactory(private val punkProvider: PunkProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PunkSearchViewModel::class.java)){
            return PunkSearchViewModel(punkProvider) as T
        }
        throw IllegalArgumentException("ViewModel unKnow")
    }
}