package com.hafidz.newsapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafidz.newsapplication.R
import com.hafidz.newsapplication.databinding.ActivityCategoryBinding
import com.hafidz.newsapplication.model.category.CategoryData
import com.hafidz.newsapplication.view.adapter.CategoryAdapter

class CategoryActivity : AppCompatActivity() {
    var binding: ActivityCategoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val listCategory = arrayListOf(
            CategoryData("BUSINESS", R.drawable.blue),
            CategoryData("ENTERTAINMENT", R.drawable.blue),
            CategoryData("GENERAL", R.drawable.blue),
            CategoryData("HEALTH", R.drawable.blue),
            CategoryData("SCIENCE", R.drawable.blue),
            CategoryData("SPORTS", R.drawable.blue),
            CategoryData("TECHNOLOGY", R.drawable.blue)
        )

        val categoryAdapter = CategoryAdapter(listCategory)
        binding?.rvCategory?.apply {
            layoutManager = LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
            categoryAdapter.onClick = {
                val intent = Intent(this@CategoryActivity, SourceActivity::class.java)
                intent.putExtra("name", it.categoryName)
                startActivity(intent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}