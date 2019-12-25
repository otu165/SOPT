package com.example.sopt.feature.gitfollower

import android.content.Intent
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.GitFollowerData
import com.example.sopt.feature.gitrepo.GitRepoActivity
import kotlinx.android.synthetic.main.rv_follower_item.view.*

class GitFollowerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.rvFollowerItem)

    private val id : TextView = view.findViewById(R.id.txtRvFollowerItemId)
    private val name : TextView = view.findViewById(R.id.txtRvFollowerItemName)
    private val img : ImageView = view.findViewById(R.id.imgRvItemImg)

    fun bind(data : GitFollowerData) {
        id.text = data.id
        name.text = data.name
        img.setImageURI(data.img?.toUri()) //TODO! 오류확인

        view?.setOnClickListener {
            Toast.makeText(view.context, "${id.text} 의 repository를 출력합니다.", Toast.LENGTH_SHORT).show()

            val intent = Intent(view.context, GitRepoActivity::class.java)
                .putExtra("id", id.text.toString())

            view.context.startActivity(intent)
        }
    }
}