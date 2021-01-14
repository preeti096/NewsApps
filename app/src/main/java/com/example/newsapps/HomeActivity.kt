package com.example.newsapps

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapps.api.NewsRepository
import com.example.newsapps.db.ArticleDatabase
import com.example.newsapps.mvvmnewsapp.Article
import com.example.newsapps.ui.adapter.HomeAdapter
import com.example.newsapps.ui.home.HomeFragment
import com.example.newsapps.viewmodel.NewsViewModel
import com.example.newsapps.viewmodel.NewsViewModelFactory

class HomeActivity : AppCompatActivity() {
    private  lateinit var rv_recyle: RecyclerView
    private  lateinit var homeAdapter: HomeAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val newsRepository = NewsRepository(ArticleDatabase.getInstance(applicationContext).getArticleDao())
        val newsViewModelFactory = NewsViewModelFactory(newsRepository)
        newsViewModel = ViewModelProvider(this, newsViewModelFactory)[NewsViewModel::class.java]
        Log.v(HomeFragment.TAG, "Calling getNews() ${Thread.currentThread().name}")
        //homeRecycleVew()
        newsViewModel.getNews()

        Log.v(HomeFragment.TAG, "Calling FINAL ${Thread.currentThread().name}")
        newsViewModel.newMutableLiveData.observe(this, Observer {
            homeAdapter.setdata(it as List<Article>)
        })
    }
//    private fun homeRecycleVew(){
//        rv_recyle = findViewById(R.id.rv_recyle)
//        homeAdapter= HomeAdapter(this, ArrayList())
//        rv_recyle.apply {
//            setHasFixedSize(true)
//            layoutManager= LinearLayoutManager(this@HomeActivity)
//            adapter=homeAdapter
//
//        }
//
//    }
}