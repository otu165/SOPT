package com.example.sopt.feature.gitfollower

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitFollowerItem

class GitFollowerAdapter(private val context : Context) : RecyclerView.Adapter<GitFollowerViewHolder>() {
    var data = listOf<GitFollowerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitFollowerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_follower_item, parent, false)
        return GitFollowerViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitFollowerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}