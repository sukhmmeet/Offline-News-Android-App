package com.dhaliwal.offlinenewsapp.API_Files

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API_Instance {
    private val retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://gnews.io/api/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiInterface by lazy {
        retrofit.create(api_interface::class.java)
    }
}