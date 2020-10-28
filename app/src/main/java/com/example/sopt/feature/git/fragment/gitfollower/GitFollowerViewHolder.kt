package com.example.sopt.feature.git.fragment.gitfollower

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt.R
import com.example.sopt.data.GitFollowerData
import com.example.sopt.data.User
import com.example.sopt.feature.git.GitActivity

class GitFollowerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvGitFollowerItem)

    private val id : TextView = view.findViewById(R.id.txtRvGitFollowerId)
    private val name : TextView = view.findViewById(R.id.txtRvGitFollowerName)
    private val img : ImageView = view.findViewById(R.id.imgRvGitFollowerUser)

    fun bind(data : GitFollowerData) {
        id.text = data.id
        name.text = data.name
        Glide.with(view).load(data.img).into(img)

        // handle click event
        view.setOnClickListener {
            User.setFollower(view.context, data.id)

            val intent = Intent(view.context, GitActivity::class.java)
            view.context.startActivity(intent)

        }
    }
}
