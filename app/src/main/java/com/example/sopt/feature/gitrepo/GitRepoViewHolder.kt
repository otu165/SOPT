package com.example.sopt.feature.gitrepo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoData
import kotlinx.android.synthetic.main.activity_git_repo.view.*

class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvRepoItem)

    private val title : TextView = view.findViewById(R.id.txtRvItemTitle)
    private val info : TextView = view.findViewById(R.id.txtRvItemInfo)
    private val date : TextView = view.findViewById(R.id.txtRvItemDate)
    private val language : TextView = view.findViewById(R.id.txtRvItemLang)

    fun bind(data : GitRepoData) {
        title.text = data.name
        info.text = data.description
        date.text = data.updateAt
        language.text = data.language
    }
}