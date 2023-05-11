package com.hafidz.newsapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidz.newsapplication.databinding.ItemCategoryBinding
import com.hafidz.newsapplication.model.category.CategoryData

class CategoryAdapter(val listCategory: List<CategoryData>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var onClick : ((CategoryData) -> Unit)? = null

    inner class ViewHolder(private var binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: CategoryData){
            binding.nameCategory.text = item.categoryName
            Glide.with(itemView).load(item.categoryPicture).into(binding.imgCategory)

            binding.category.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listCategory.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listCategory[position])
}