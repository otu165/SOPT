package com.example.sopt.feature.gitrepo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitRepoItem



class GitRepoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvRepoItem)

//    private val imageView : ImageView = view.findViewById(R.id.imgRvItemImg)
    private val txtId : TextView = view.findViewById(R.id.txtRvItemId)
    private val txtName : TextView = view.findViewById(R.id.txtRvItemName)

    fun bind(item : GitRepoItem) {
//        imageView.setImageResource(item.img.toInt()) //TODO! ImageView의 타입은?
        txtId.text = item.id
        txtName.text = item.name
    }
}