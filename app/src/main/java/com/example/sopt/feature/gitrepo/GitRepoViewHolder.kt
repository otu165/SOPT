package com.example.sopt.feature.gitrepo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoData

class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvGitRepoItem)

    private val title : TextView = view.findViewById(R.id.txtRvGitRepoName)
    private val info : TextView = view.findViewById(R.id.txtRvGitRepoDescription)
    private val date : TextView = view.findViewById(R.id.txtRvGitRepoUpdatedAt)
    private val language : TextView = view.findViewById(R.id.txtRvGitRepoLanguage)

    fun bind(data : GitRepoData) {
        title.text = data.name
        info.text = data.description
        date.text = data.updateAt
        language.text = data.language
    }
}