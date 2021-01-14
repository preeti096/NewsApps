package com.example.newsapps.mvvmnewsapp

data class NewsResponses(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)