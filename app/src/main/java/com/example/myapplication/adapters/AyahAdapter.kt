package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemRecitationBinding
import com.example.myapplication.models.Ayah

class AyahAdapter : RecyclerView.Adapter<AyahAdapter.AyahViewHolder>() {
    private var surahList: List<Ayah> = ArrayList()
    private var listener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val binding = ListItemRecitationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyahViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return surahList.size
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        holder.bind(surahList[position])
    }

    class AyahViewHolder(private val binding: ListItemRecitationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Ayah) {
            binding.AyahArabic.text = item.text
            binding.AyahManzil.text = "Manzil : ${item.manzil}"
            binding.AyahNumber.text = item.number.toString()
            binding.AyahRuku.text = "Ruku : ${item.ruku}"
            binding.AyahSajda.text = "Sajda : ${item.sajda}"
            binding.JuzOfAyah.text = "Juz : ${item.juz}"
        }
    }

    interface OnClickListener {
        fun onItemClick(item: Ayah)
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    fun submitListToAdapter(videoList: List<Ayah>)
    {
        this.surahList = videoList
        notifyDataSetChanged()
    }

}