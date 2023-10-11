package com.example.myapplication.models

data class Edition(
    val identifier: String,
    val language: String,
    val name: String,
    val englishName: String,
    val format: String,
    val type: String,
    val direction: String
)