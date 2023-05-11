package com.hafidz.newsapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hafidz.newsapplication.databinding.ItemArticleBinding
import com.hafidz.newsapplication.databinding.ItemCategoryBinding
import com.hafidz.newsapplication.model.articles.Article
import com.hafidz.newsapplication.model.category.CategoryData

class ArticleAdapter(val listArticle: List<Article>): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    var onClick : ((Article) -> Unit)? = null

    inner class ViewHolder(private var binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Article){
            binding.titleArticle.text = item.title
            Glide.with(itemView).load(item.urlToImage).into(binding.imgArticle)
            binding.article.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listArticle[position])
}