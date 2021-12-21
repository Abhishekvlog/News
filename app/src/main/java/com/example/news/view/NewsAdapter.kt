package com.example.news.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.Models.Room.News
import com.example.news.R

class NewsAdapter(
    val context: Context,
    val newsList: MutableList<News>
) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.item_layout, parent, false)
        return NewsViewHolder(view1)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.author.text =news.author
        holder.title.text = news.title

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var iamge: ImageView
    var title: TextView
    var author: TextView

    init {
        title = itemView.findViewById(R.id.title_Show)
        author = itemView.findViewById(R.id.author_name)
        iamge = itemView.findViewById(R.id.poster_Show)
    }
}