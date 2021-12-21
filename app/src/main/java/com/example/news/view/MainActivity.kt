package com.example.news.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.Models.Room.News
import com.example.news.Models.Room.NewsDAO
import com.example.news.Models.Room.NewsRoomDataBase
import com.example.news.R
import com.example.news.Repo.MyRepo
import com.example.news.ViewModel.MainViewModel
import com.example.news.ViewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var newsAdapter: NewsAdapter
    private var newsList = mutableListOf<News>()

    lateinit var roomDb: NewsRoomDataBase
    lateinit var newsDao: NewsDAO
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDb = NewsRoomDataBase.getDatabaseObject(this)
        newsDao = roomDb.funGetTaskDao()

        val repo = MyRepo(newsDao)
        val newsViewModelFactory = MainViewModelFactory(repo)



        viewModel = ViewModelProviders.of(this, newsViewModelFactory)
            .get(MainViewModel::class.java)

        viewModel.getApi()

        viewModel.getNews().observe(this, Observer {
            newsList = it as MutableList<News>
            setAdapter()
        })


    }

    private fun setAdapter() {
        newsAdapter = NewsAdapter(this, newsList)
        recycler_View.layoutManager = LinearLayoutManager(this)
        recycler_View.adapter = newsAdapter
    }
}