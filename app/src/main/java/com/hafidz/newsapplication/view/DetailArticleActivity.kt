package com.hafidz.newsapplication.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import com.hafidz.newsapplication.R
import com.hafidz.newsapplication.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private var binding: ActivityDetailArticleBinding? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val getUrl = intent.extras
        val url = getUrl?.getString("url")
        Toast.makeText(this, "News URL : $url", Toast.LENGTH_SHORT).show()

        binding?.wvDetail?.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url!!)
            settings.setSupportZoom(true)
        }
    }
}