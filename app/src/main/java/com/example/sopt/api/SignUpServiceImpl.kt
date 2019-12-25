package com.example.sopt.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignUpServiceImpl {
    private const val BASE_URL = "http://3.215.131.244:3000"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : SignUpService = retrofit.create(SignUpService::class.java)
}