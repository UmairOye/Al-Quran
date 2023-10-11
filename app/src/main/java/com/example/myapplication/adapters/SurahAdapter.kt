package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemSurahBinding
import com.example.myapplication.models.SurahModel

class SurahAdapter : RecyclerView.Adapter<SurahAdapter.SurahViewModel>() {
    private var surahList: List<SurahModel> = ArrayList()
    private var listener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewModel {
        val binding = ListItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahViewModel(binding)
    }

    override fun getItemCount(): Int {
        return surahList.size
    }

    override fun onBindViewHolder(holder: SurahViewModel, position: Int) {
        holder.bind(surahList[position])
        holder.cdMain.setOnClickListener { listener?.onItemClick(surahList.get(position)) }
    }

    class SurahViewModel(private val binding: ListItemSurahBinding) : RecyclerView.ViewHolder(binding.root) {
        val cdMain = binding.cdMain

        fun bind(item: SurahModel) {
            binding.surahNameArabic.text = item.name
            binding.surahNameEnglish.text = item.englishName
            "Revelation Type : ${item.revelationType}".also { binding.SurahRevelationType.text = it }
            binding.surahNameMeaning.text = item.englishNameTranslation
            binding.numberOfSurah.text = item.number.toString()
            "Ayahs No :  ${item.numberOfAyahs}".also { binding.surahNumberOfAyahs.text = it }
        }
    }

    interface OnClickListener {
        fun onItemClick(item: SurahModel)
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    fun submitListToAdapter(videoList: List<SurahModel>)
    {
        this.surahList = videoList
        notifyDataSetChanged()
    }

}