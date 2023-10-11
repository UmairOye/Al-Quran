package com.example.myapplication.data.remote.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.ApiClient
import com.example.myapplication.data.remote.repo.QuranRepo
import com.example.myapplication.models.Ayah
import com.example.myapplication.models.SurahData
import com.example.myapplication.models.SurahModel

class QuranViewModel: ViewModel() {
    private val quranApi = ApiClient.quranApi
    private val repo = QuranRepo(quranApi)

    fun getQuranSurah(): LiveData<List<SurahModel>>
    {
        return repo.getSurahList()
    }

    fun getSurahList(surahNumber: Int):LiveData<List<Ayah>>
    {
        return repo.getSurah(surahNumber)
    }



}