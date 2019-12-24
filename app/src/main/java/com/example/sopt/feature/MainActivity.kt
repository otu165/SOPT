package com.example.sopt.feature

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : WebToonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        //변수 초기화
        recyclerView = findViewById(R.id.rvMain)
        adapter = WebToonAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        adapter.data = WebToonList().getWebToonList()

        adapter.notifyDataSetChanged()

    }
}
