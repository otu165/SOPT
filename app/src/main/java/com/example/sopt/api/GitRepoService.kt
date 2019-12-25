package com.example.sopt.api

import com.example.sopt.data.GitRepoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitRepoService {
    @GET("/users/{login}/repos")
    fun getRepos(@Path("login") login : String) : Call<List<GitRepoData>>
}