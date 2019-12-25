package com.example.sopt.feature.gitrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.api.GitRepoService
import com.example.sopt.api.GitRepoServiceImpl
import com.example.sopt.data.GitRepoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        getGitRepo()
    }

    private fun getGitRepo() {
        val call : Call<List<GitRepoData>> = GitRepoServiceImpl.service.getRepos(intent.getStringExtra("id"))

        call.enqueue(
            object : Callback<List<GitRepoData>> {
                override fun onFailure(call: Call<List<GitRepoData>>, t: Throwable) {
                    Log.e("TAG", "GitRepoActivity 서버통신불가")
                }

                override fun onResponse(
                    call: Call<List<GitRepoData>>,
                    response: Response<List<GitRepoData>>
                ) {
                    if (response.isSuccessful) {
                        adapter.data = response.body()!!
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}
