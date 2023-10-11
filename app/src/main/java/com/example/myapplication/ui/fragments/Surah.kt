package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.adapters.SurahAdapter
import com.example.myapplication.data.remote.viewModel.QuranViewModel
import com.example.myapplication.databinding.FragmentSurahBinding
import com.example.myapplication.models.SurahModel
import com.example.myapplication.utils.addOnBackPressedCallback

class Surah : Fragment() {
    private var _binding: FragmentSurahBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuranViewModel by activityViewModels()
    private lateinit var adapter: SurahAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurahBinding.inflate(inflater, container, false)
        addOnBackPressedCallback {  }

        adapter = SurahAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.getQuranSurah().observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            adapter.submitListToAdapter(it)
        }


        adapter.setOnClickListener(listener = object : SurahAdapter.OnClickListener {
            override fun onItemClick(item: SurahModel) {
                try {
                    val bundle = Bundle()
                    bundle.putInt("number", item.number)
                    bundle.putString("surahName", item.name)
                    findNavController().navigate(R.id.action_surah_to_surahRecitation, bundle)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }

        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}