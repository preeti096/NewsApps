package com.example.newsapps.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapps.mvvmnewsapp.Article


@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article): Long

    @Update
    suspend fun updatenews(articles: Article)

    @Query("SELECT * FROM articles")
    fun getArticleById(): LiveData<List<Article>>

}