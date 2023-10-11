package com.example.myapplication.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApi {
    @GET("v1/surah")
    fun getSurahList(): Call<SurahResponse>

    @GET("v1/surah/{surahNumber}")
    fun getSurah(@Path("surahNumber") surahNumber: Int): Call<SurahInfo>

}