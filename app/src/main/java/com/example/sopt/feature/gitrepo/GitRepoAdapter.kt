package com.example.sopt.feature.gitrepo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoItem

class GitRepoAdapter(private val context : Context) : RecyclerView.Adapter<GitRepoViewHolder>() {
    var data = listOf<GitRepoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_repository_item, parent, false)
        return GitRepoViewHolder(view)
    }

    //Adapter -> ViewHolder 데이터 전달
    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}