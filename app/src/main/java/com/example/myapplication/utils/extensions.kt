package com.example.myapplication.utils

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

fun Fragment.addOnBackPressedCallback(onBackPressed: () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(
        viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })
}