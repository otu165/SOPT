package com.example.sopt.data

import android.net.Uri
import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class GitFollowerData (
    @SerializedName("login")
    val id : String,
    @SerializedName("name")
    val name : String?,
    @SerializedName("avatar_url")
    val img : String?
)