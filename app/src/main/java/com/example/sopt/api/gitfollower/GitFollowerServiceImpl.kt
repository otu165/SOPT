package com.example.sopt.api.gitfollower

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitFollowerServiceImpl {
    private const val BASE_URL = "https://api.github.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : GitFollowerService = retrofit.create(
        GitFollowerService::class.java)
}