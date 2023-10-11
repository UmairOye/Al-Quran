package com.example.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val quranApi: QuranApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.alquran.cloud/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuranApi::class.java)
    }
}