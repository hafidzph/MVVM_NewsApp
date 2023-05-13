package com.hafidz.newsapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafidz.newsapplication.model.articles.Article
import com.hafidz.newsapplication.model.articles.ResponseDataArticle
import com.hafidz.newsapplication.network.NetworkClient
import com.hafidz.newsapplication.network.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(var api: NetworkService): ViewModel() {
    private val _article = MutableLiveData<List<Article>>()
    val article: LiveData<List<Article>> = _article

    fun getAllArticles(source: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = api.getArticle(source)
            viewModelScope.launch(Dispatchers.Main) {
                if(response != null) _article.postValue(response.articles) else Log.d("Error", "Response Null")
            }
        }
    }
}