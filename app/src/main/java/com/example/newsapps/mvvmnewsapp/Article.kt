package com.example.newsapps.mvvmnewsapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
        tableName = "articles"
)
data class Article(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var author: String? = null,
        var content: String? = null,
        var description: String? = null,
        var publishedAt: String? = null,
        var source: Source?,
        var title: String? = null,
        var url: String? = null,
        var urlToImage: String? = null
)
