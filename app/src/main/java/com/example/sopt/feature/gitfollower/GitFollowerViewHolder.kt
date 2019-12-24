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

        //ClickListener 설정
        view.setOnClickListener {
            Toast.makeText(view.context, "${txtId.text} 의 저장소 내역을 출력합니다.", Toast.LENGTH_SHORT).show()

            val intent = Intent(view.context, GitRepoActivity::class.java)
                .putExtra("id", txtId.text.toString())

            view.context.startActivity(intent)
        }
    }
}