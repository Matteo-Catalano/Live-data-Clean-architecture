package com.android.example.cleanarchietetture_viemodellivedata.punkApi.network

import com.android.example.cleanarchietetture_viemodellivedata.punkApi.network.dto.BeersResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PunkService {
    @GET("{beers}")
    suspend fun listRepos(@Path("beers") beers: String, @Query ("per_page") pageSize: Int): BeersResult
}