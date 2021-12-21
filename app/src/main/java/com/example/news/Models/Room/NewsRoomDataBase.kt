package com.example.news.Models.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [News::class], version = 1)
abstract class NewsRoomDataBase : RoomDatabase() {

    abstract fun funGetTaskDao(): NewsDAO

    companion object{
        private var INSTANCE: NewsRoomDataBase? = null

        fun getDatabaseObject(context: Context): NewsRoomDataBase {

            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    NewsRoomDataBase::class.java,
                    "news_db"
                )

                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }

    }
}