package com.example.sopt.data

import com.google.gson.annotations.SerializedName

data class GitRepoData (
    @SerializedName("name")
    val name : String,
    @SerializedName("description")
    val description : String?,
    @SerializedName("updated_at")
    val updateAt : String?,
    @SerializedName("language")
    val language : String?
)