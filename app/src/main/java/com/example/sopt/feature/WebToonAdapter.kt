package com.example.sopt.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.WebToonItem

class WebToonAdapter(private val context : Context) : RecyclerView.Adapter<WebToonViewHolder>() {
    var data = listOf<WebToonItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebToonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_webtoon_item, parent, false)
        return WebToonViewHolder(view)
    }

    override fun onBindViewHolder(holder: WebToonViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}