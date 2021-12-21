package com.example.news.Models

import com.example.news.Models.remote.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("v2/everything?q=tesla&from=2021-11-20&sortBy=publishedAt&apiKey=90b71e0a0ff34c248e699ddd46014b65")
    suspend fun getNews() : ResponseData
}