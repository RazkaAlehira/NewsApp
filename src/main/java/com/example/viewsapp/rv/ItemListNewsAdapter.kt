package com.example.viewsapp.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewsapp.data.News
import com.example.viewsapp.databinding.ItemListNewsBinding

class ItemListNewsAdapter : RecyclerView.Adapter<ItemListNewsViewHolder>() {
    private val listNews = ArrayList<News>()

    fun addData(data : List<News>) {
        listNews.clear()
        listNews.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListNewsBinding.inflate(layoutInflater,parent,false)
        return ItemListNewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: ItemListNewsViewHolder, position: Int) {
        val data = listNews[position]
        holder.bind(data)
    }
}