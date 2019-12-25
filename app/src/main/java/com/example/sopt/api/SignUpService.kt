package com.example.sopt.api

import com.example.sopt.data.SignUpData
import com.example.sopt.data.SignUpServerMsg
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("/api/auth/signup")
    fun requestSignUp(@Body body : SignUpData) : Call<SignUpServerMsg>
}