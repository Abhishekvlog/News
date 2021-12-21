package com.example.news.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.news.Models.Room.News
import com.example.news.Repo.MyRepo

class MainViewModel(val repo: MyRepo) : ViewModel() {

    fun getNews() : LiveData<List<News>>{
        return repo.getAllNews()
    }

    fun getApi() {
        repo.getApi()
    }


}