package com.example.newsapps

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapps.ui.adapter.HomeAdapter
import com.example.newsapps.viewmodel.NewsViewModel

class DetailsAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmenthome_details)
        //get data from intent
        val intent = intent
        val description = intent.getStringExtra("description")
        val urlToImage = intent.getStringExtra("urlToImage")
        val content = intent.getStringExtra("content")
        val url = intent.getStringExtra("url")
        val img_details = findViewById<ImageView>(R.id.img_details)
        val tv_deatils_content = findViewById<TextView>(R.id.tv_deatils_content)
        val tv_deatils_desc = findViewById<TextView>(R.id.tv_deatils_desc)
        val tv_detail_url = findViewById<TextView>(R.id.tv_detail_url)
        //setText
        Glide.with(this).load(urlToImage).into(img_details)
        tv_deatils_desc.text=description
        tv_deatils_content.text=content





    }

}