package com.example.newsapps.api

import com.example.newsapps.api.Constants.Companion.API_KEY
import com.example.newsapps.api.Constants.Companion.BASE_URL
import com.example.newsapps.mvvmnewsapp.NewsResponses
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponses>
}

object NewsService {
    val newsInstance: NewsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsApi::class.java)
    }



}
