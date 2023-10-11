package com.example.myapplication.api

import com.example.myapplication.models.SurahData

data class SurahInfo(
    val code: Int,
    val status: String,
    val data: SurahData
)