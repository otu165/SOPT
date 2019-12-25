package com.example.sopt.api.signin

import com.example.sopt.data.SignInData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("/api/auth/signin")
    fun requestSignIn(@Body body : SignInData) : Call<SignInData>
}
