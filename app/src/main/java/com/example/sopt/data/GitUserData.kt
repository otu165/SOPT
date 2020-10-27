package com.example.sopt.data

import com.google.gson.annotations.SerializedName

data class GitUserData(
    @SerializedName("login")
    val id : String,
    @SerializedName("avatar_url")
    val image : String?,
    @SerializedName("bio")
    val description : String?
)