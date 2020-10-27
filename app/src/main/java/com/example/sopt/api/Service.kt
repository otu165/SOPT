package com.example.sopt.api

import com.example.sopt.data.GitFollowerData
import com.example.sopt.data.GitRepoData
import com.example.sopt.data.GitUserData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    // login
    @GET("/users/{username}")
    fun getUser(@Path("username") username : String) : Call<GitUserData>

    // follower
    @GET("/users/{login}/followers")
    fun getFollower(@Path("login") login : String) : Call<List<GitFollowerData>>

    // repository
    @GET("/users/{login}/repos")
    fun getRepos(@Path("login") login : String) : Call<List<GitRepoData>>
}