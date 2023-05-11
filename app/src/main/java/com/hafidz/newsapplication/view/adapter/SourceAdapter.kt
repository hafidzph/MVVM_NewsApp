package com.hafidz.newsapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafidz.newsapplication.databinding.ItemSourceBinding
import com.hafidz.newsapplication.model.category.CategoryData
import com.hafidz.newsapplication.model.sources.Source

class SourceAdapter(val listSource: List<Source>): RecyclerView.Adapter<SourceAdapter.ViewHolder>() {
    var onClick : ((Source) -> Unit)? = null

    inner class ViewHolder(private var binding: ItemSourceBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Source){
            binding.apply {
                nameSource.text = item.name
                cvSource.setOnClickListener {
                    onClick?.invoke(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listSource.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listSource[position])
}