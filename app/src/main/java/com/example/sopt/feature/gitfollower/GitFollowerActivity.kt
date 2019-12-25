package com.example.sopt.feature.gitfollower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.sopt.R
import com.example.sopt.api.GitFollowerServiceImpl
import com.example.sopt.data.GitFollowerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        getFollower()
    }

    private fun getFollower() {
        val call : Call<List<GitFollowerData>> = GitFollowerServiceImpl.service.getFollower(intent.getStringExtra("id")!!)

        call.enqueue(
            object : Callback<List<GitFollowerData>> {
                override fun onFailure(call: Call<List<GitFollowerData>>, t: Throwable) {
                    Log.e("TAG", "GitFollowerActivity 서버 통신 불가")
                }

                override fun onResponse(
                    call: Call<List<GitFollowerData>>,
                    response: Response<List<GitFollowerData>>
                ) {
                    if (response.isSuccessful) {
                        //adapter에 데이터 전달
                        adapter.data = response.body()!!
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}
