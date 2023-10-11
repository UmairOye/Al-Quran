package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.adapters.AyahAdapter
import com.example.myapplication.data.remote.viewModel.QuranViewModel
import com.example.myapplication.databinding.FragmentSurahRecitationBinding
import com.example.myapplication.utils.addOnBackPressedCallback

class SurahRecitation : Fragment() {
    private var _binding: FragmentSurahRecitationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuranViewModel by activityViewModels()
    private lateinit var adapter: AyahAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurahRecitationBinding.inflate(inflater, container, false)
        addOnBackPressedCallback { findNavController().popBackStack() }

        val surahName: String = requireArguments().getString("surahName").toString()
        binding.SurahName.text = surahName
        val surahNumber: Int = requireArguments().getInt("number")

        adapter = AyahAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.getSurahList(surahNumber).observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            adapter.submitListToAdapter(it)
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}