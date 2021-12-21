package com.example.news.Repo

import androidx.lifecycle.LiveData
import com.example.news.Models.ApiClient
import com.example.news.Models.Network
import com.example.news.Models.Room.News
import com.example.news.Models.Room.NewsDAO
import com.example.news.Models.remote.ResponseData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyRepo(val newsDAO: NewsDAO) {



    fun getApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiClient = Network.getInstance().create(ApiClient::class.java).getNews()
            saveToDB(apiClient)
        }

    }

    private fun saveToDB(apiClient: ResponseData) {
        var list = ArrayList<News>()
        for (i in apiClient.articles){
            var news = News(i.url , i.title , i.author)
            list.add(news)
        }
        newsDAO.deleteAllFromNews()
        newsDAO.addListOfNews(list)
    }

//    fun addToRoom(task: News) {
//        CoroutineScope(Dispatchers.IO).launch {
//
//            newsDAO.addNews(task)
//        }
//    }


    fun getAllNews(): LiveData<List<News>> {
        return newsDAO.getNews()
    }


}