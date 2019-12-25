package com.example.sopt.api

import com.example.sopt.data.GitFollowerData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitFollowerService {
    @GET("/users/{login}/following")
    fun getFollower(@Path("login") login : String) : Call<List<GitFollowerData>>
}