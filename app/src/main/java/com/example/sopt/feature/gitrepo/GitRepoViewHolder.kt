package com.example.sopt.feature.gitrepo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoItem

class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvRepoItem)

    private val txtTitle : TextView = view.findViewById(R.id.txtRvItemTitle)
    private val txtInfo : TextView = view.findViewById(R.id.txtRvItemInfo)
    private val txtLanguage : TextView = view.findViewById(R.id.txtRvItemLang)

    fun bind(data : GitRepoItem) {
        txtTitle.text = data.title
        txtInfo.text = data.info
        txtLanguage.text = data.language
    }
}