package com.example.sopt.feature.git.fragment.gitrepo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoData

class GitRepoAdapter(private val context : Context) : RecyclerView.Adapter<GitRepoViewHolder>() {
    var data = listOf<GitRepoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_repository_item, parent, false)
        return GitRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}