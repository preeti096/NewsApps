package com.example.newsapps.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapps.api.NewsRepository
import com.example.newsapps.db.ArticleDao
import com.example.newsapps.mvvmnewsapp.Article
import com.example.newsapps.mvvmnewsapp.NewsResponses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel(){


    val newMutableLiveData: MutableLiveData<List<Article>> = MutableLiveData()

    init {
        Log.d(TAG, "init{}")
    }

    fun getNews() {
        viewModelScope.launch {
            try {
                val response = newsRepository.getBreakingNews()
                Log.d(TAG, "getNews : ${response.body()}")
                if (response.isSuccessful && response.body() != null) {
                    newMutableLiveData.value = response.body()?.articles
                    //newsRepository.insert(response.body()?.articles)


                }
            } catch (e: Exception) {
                Log.d(TAG, "getNews : ${e.message}")
            }
        }
    }
    fun insert(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        newsRepository.insert(article)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared()")
    }

    companion object {
        const val TAG = "NewsViewModel"
    }


}