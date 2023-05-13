package com.hafidz.newsapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafidz.newsapplication.R
import com.hafidz.newsapplication.databinding.ActivitySourceBinding
import com.hafidz.newsapplication.view.adapter.SourceAdapter
import com.hafidz.newsapplication.viewmodel.SourceViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.xml.transform.Source

@AndroidEntryPoint
class SourceActivity : AppCompatActivity() {
    var binding: ActivitySourceBinding? = null
    val sourceVM: SourceViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val intent = intent.extras

        sourceVM.getAllSource(intent?.getString("name")!!)
        binding?.rvSource?.apply {
            sourceVM.source.observe(this@SourceActivity){ source ->
                val adapterSrc = SourceAdapter(source)
                layoutManager = LinearLayoutManager(this@SourceActivity,
                        LinearLayoutManager.VERTICAL,
                        false)
                adapter = adapterSrc
                adapterSrc.onClick = {
                    val intents = Intent(this@SourceActivity, ArticleActivity::class.java)
                    intents.putExtra("source", it.id)
                    startActivity(intents)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}