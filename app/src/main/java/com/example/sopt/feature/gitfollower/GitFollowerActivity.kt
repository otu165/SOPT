package com.example.sopt.feature.gitfollower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.sopt.R

class GitFollowerActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : GitFollowerAdapter

    private var snapHelper : SnapHelper = LinearSnapHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_follower)

        gitFollowerFunction()
    }

    private fun gitFollowerFunction() {
        //변수 초기화
        recyclerView = findViewById(R.id.rvGitFollower)
        adapter = GitFollowerAdapter(this)

        //SnapHelper 적용
        snapHelper.attachToRecyclerView(recyclerView)

        //adapter 및 layout 지정
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //데이터 전달
        adapter.data = GitFollowerList().getFollowerList()

        //데이터 변화 알림
        adapter.notifyDataSetChanged()
    }
}
