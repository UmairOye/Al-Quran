package com.example.myapplication.data.remote.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.QuranApi
import com.example.myapplication.api.SurahInfo
import com.example.myapplication.api.SurahResponse
import com.example.myapplication.models.Ayah
import com.example.myapplication.models.SurahData
import com.example.myapplication.models.SurahModel
import com.example.myapplication.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranRepo(private val quranApi: QuranApi) {
    fun getSurahList(): LiveData<List<SurahModel>> {
        val surahListLiveData = MutableLiveData<List<SurahModel>>()

        quranApi.getSurahList().enqueue(object : Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                if (response.isSuccessful) {
                    surahListLiveData.postValue(response.body()?.data)
                }
            }

            override fun onFailure(call: Call<SurahResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        return surahListLiveData
    }


    fun getSurah(surahNumber: Int):LiveData<List<Ayah>>
    {
        val surahListLiveData = MutableLiveData<List<Ayah>>()
        quranApi.getSurah(surahNumber).enqueue(object : Callback<SurahInfo> {
            override fun onResponse(call: Call<SurahInfo>, response: Response<SurahInfo>) {
                if (response.isSuccessful) { 
                    val surahData = response.body()?.data
                    surahListLiveData.postValue(surahData?.ayahs)
                }
            }

            override fun onFailure(call: Call<SurahInfo>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        return surahListLiveData
    }
}