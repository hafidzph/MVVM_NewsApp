package com.hafidz.newsapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafidz.newsapplication.R
import com.hafidz.newsapplication.databinding.ActivityArticleBinding
import com.hafidz.newsapplication.view.adapter.ArticleAdapter
import com.hafidz.newsapplication.viewmodel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleActivity : AppCompatActivity() {
    private var binding: ActivityArticleBinding? = null
    private val articleVm: ArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val intents = intent.extras
        articleVm.getAllArticles(intents?.getString("source")!!)

        binding?.rvArticle?.apply {
            articleVm.article.observe(this@ArticleActivity){ article ->
                val articleAdapter = ArticleAdapter(article)
                layoutManager =
                    LinearLayoutManager(this@ArticleActivity, LinearLayoutManager.VERTICAL, false)
                adapter = articleAdapter
                articleAdapter.onClick = {
                    val intentArticle = Intent(this@ArticleActivity, DetailArticleActivity::class.java)
                    intentArticle.putExtra("url", it.url)
                    startActivity(intentArticle)
                }
            }
        }
    }
}