package com.example.sopt.data

import com.google.gson.annotations.SerializedName

//로그인 시 서버로 넘기는 데이터
data class SignInData(
    val id : String,
    val pwd : String
)