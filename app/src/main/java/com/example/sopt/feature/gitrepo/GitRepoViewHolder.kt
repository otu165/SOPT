package com.example.sopt.feature.gitrepo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoItem

class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvRepoItem)
    private val txtName : TextView = view.findViewById(R.id.txtRvItemName)
    private val txtAge: TextView = view.findViewById(R.id.txtRvItemAge)
    private val txtMajor : TextView = view.findViewById(R.id.txtRvItemMajor)

    fun bind(item : GitRepoItem) {
        txtName.text = item.name
        txtAge.text = item.age.toString()
        txtMajor.text = item.major
    }
}