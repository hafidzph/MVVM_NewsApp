package com.hafidz.newsapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hafidz.newsapplication.model.articles.Article
import com.hafidz.newsapplication.model.articles.ResponseDataArticle
import com.hafidz.newsapplication.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ArticleViewModel(private val app: Application): AndroidViewModel(app) {
    private val _article = MutableLiveData<List<Article>>()
    val article: LiveData<List<Article>> = _article

    fun getAllArticles(source: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NetworkClient.instance.getArticle(source)
            viewModelScope.launch(Dispatchers.Main) {
                if(response != null) _article.postValue(response.articles) else Log.d("Error", "Response Null")
            }
        }
    }
}