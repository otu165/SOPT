package com.example.sopt.data

import com.google.gson.annotations.SerializedName

data class SignUpServerMsg (
    @SerializedName("message")
    val message : String
)