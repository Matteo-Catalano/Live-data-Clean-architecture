package com.android.example.cleanarchietetture_viemodellivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel (private val punkService: PunkService): ViewModel() {

    private var _repos = MutableLiveData<BeersResult>()
    val repos: LiveData<BeersResult>
       get() = _repos

    private var _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error




    fun retrieveRepos(beername : String){
        CoroutineScope(Dispatchers.Main).launch {
            try {

                _repos.value = punkService.listRepos(beername)
            } catch (e : Exception){
                _error.value = e.localizedMessage
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}
