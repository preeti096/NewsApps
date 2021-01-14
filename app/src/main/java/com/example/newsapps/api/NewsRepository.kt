package com.example.newsapps.api

import androidx.lifecycle.MutableLiveData
import com.example.newsapps.db.ArticleDao
import com.example.newsapps.mvvmnewsapp.Article
import com.example.newsapps.mvvmnewsapp.NewsResponses
import retrofit2.Response

/**
 * It provide news from server or from database.
 */
class NewsRepository(
        private val articleDao: ArticleDao
) {
    suspend fun getBreakingNews(): Response<NewsResponses> = NewsService.newsInstance.getBreakingNews(countryCode = "in")

    suspend fun insertAll(articles: List<Article>) {
        articleDao.insertAll(articles)
    }

    suspend fun insert(article: Article) {
        articleDao.insert(article)
    }

}