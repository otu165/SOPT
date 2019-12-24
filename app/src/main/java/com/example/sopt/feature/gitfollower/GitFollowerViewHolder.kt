package com.example.sopt.feature.gitfollower

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitFollowerItem
import com.example.sopt.feature.gitrepo.GitRepoActivity

class GitFollowerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvFollowerItem)
    private val txtId : TextView = view.findViewById(R.id.txtRvFollowerItemId)
    private val txtName : TextView = view.findViewById(R.id.txtRvFollowerItemName)

    fun bind(data : GitFollowerItem) {
        txtId.text = data.id
        txtName.text = data.name
    }
}