package com.hafidz.newsapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidz.newsapplication.model.sources.ResponseDataSource
import com.hafidz.newsapplication.model.sources.Source
import com.hafidz.newsapplication.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceViewModel(private val app: Application): AndroidViewModel(app) {
    private val _source = MutableLiveData<List<Source>>()
    val source: LiveData<List<Source>> = _source

    fun getAllSource(category: String){
        NetworkClient.instance.getAllSources(category)
            .enqueue(object : Callback<ResponseDataSource> {
                override fun onResponse(
                    call: Call<ResponseDataSource>,
                    response: Response<ResponseDataSource>
                ) {
                    if(response.isSuccessful) _source.postValue(response.body()?.sources)
                }

                override fun onFailure(call: Call<ResponseDataSource>, t: Throwable) {
                    Log.d("Error", t.message!!)
                }
            })
    }
}