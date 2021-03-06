package com.example.news.Models.remote


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)