package com.example.news.Models.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(task: News)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListOfNews(task: ArrayList<News>)

    @Query("Delete from news_table")
    fun deleteAllFromNews()

    @Query("Select * from news_table")
    fun getNews():LiveData<List<News>>

    @Update
    fun update(task: News)
}