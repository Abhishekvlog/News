package com.example.news.Models.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class News(
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "author") var author: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}