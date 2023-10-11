package com.example.myapplication.api

import com.example.myapplication.models.SurahModel

data class SurahResponse(
    val code: Int,
    val status: String,
    val data: List<SurahModel>
)
