package com.example.sopt.feature.gitfollower

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.StrictMode
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt.R
import com.example.sopt.data.GitFollowerData
import java.net.URL

class GitFollowerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvGitFollowerItem)

    private val id : TextView = view.findViewById(R.id.txtRvGitFollowerId)
    private val name : TextView = view.findViewById(R.id.txtRvGitFollowerName)
    private val img : ImageView = view.findViewById(R.id.imgRvGitFollowerUser)

    fun bind(data : GitFollowerData) {
        id.text = data.id
        name.text = data.name
        Glide.with(view).load(data.img).into(img)
    }
}
