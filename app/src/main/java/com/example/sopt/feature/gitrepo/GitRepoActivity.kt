package com.example.sopt.feature.gitrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R

class GitRepoActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : GitRepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        gitRepoFunction()
    }

    private fun gitRepoFunction() {
        //변수 초기화
        recyclerView = findViewById(R.id.rvGitRepo)
        adapter = GitRepoAdapter(this)

        //adapter 및 manager 지정
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //데이터 전달
        adapter.data = GitRepoList().getRepoList()

        //데이터 변화 알림
        adapter.notifyDataSetChanged()
    }
}
