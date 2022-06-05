package com.android.example.cleanarchietetture_viemodellivedata

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PunkProvider {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var punkService = retrofit.create(PunkService::class.java)


    fun provide():PunkService = punkService
}