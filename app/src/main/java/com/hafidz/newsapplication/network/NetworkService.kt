package com.hafidz.newsapplication.network

import com.hafidz.newsapplication.model.articles.ResponseDataArticle
import com.hafidz.newsapplication.model.sources.ResponseDataSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = "c3fb65d1575948e487c93a67886397ef"
    ): Call<ResponseDataSource>

    @GET("top-headlines")
    suspend fun getArticle(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = "c3fb65d1575948e487c93a67886397ef"
    ): ResponseDataArticle
}