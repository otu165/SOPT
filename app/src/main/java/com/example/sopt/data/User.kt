package com.example.sopt.data

import android.content.Context

object User {
    private const val LOGIN_KEY = "login" // 저장소 식별자

    private const val USER_KEY = "user" // main user
    private const val FOLLOWER_KEY = "follower" // followers

    fun getUser(context : Context) :String {
        val sharedPreferences = context.getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE)
        return sharedPreferences.getString(USER_KEY, "") ?: ""
    }

    fun setUser(context : Context, id : String) {
        val sharedPreferences = context.getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(USER_KEY, id).apply()
    }

    fun clearUser(context : Context) {
        val sharedPreferences = context.getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }

    fun getFollower(context : Context) : String {
        val sharedPreferences = context.getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE)
        return sharedPreferences.getString(FOLLOWER_KEY, "") ?: ""
    }

    fun setFollower(context : Context, id : String) {
        val sharedPreferences = context.getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(FOLLOWER_KEY, id).apply()
    }

    fun clearFollower(context : Context) {
        val sharedPreferences = context.getSharedPreferences(LOGIN_KEY, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(FOLLOWER_KEY).apply()
    }
}