package com.example.sopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GitRepoActivity : AppCompatActivity() {
    private lateinit var rvGitRepo : RecyclerView
    private lateinit var gitRepoAdapter : GitRepoAdapter

    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        gitRepoFunction()
    }

    private fun gitRepoFunction() {
        //변수 초기화
        rvGitRepo = findViewById(R.id.rvGitRepo)
        gitRepoAdapter = GitRepoAdapter(this)

        //RecyclerView의 adapter, layoutManager 지정
        rvGitRepo.adapter = gitRepoAdapter
        rvGitRepo.layoutManager = LinearLayoutManager(this)

        //데이터 전달
        gitRepoAdapter.data = listOf(
            GitRepoItem(
                name = "A",
                age = 20,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "B",
                age = 21,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "C",
                age = 22,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "D",
                age = 23,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "E",
                age = 24,
                major = "컴퓨터공학과"
            )
        )

        //데이터 변화 알림
        gitRepoAdapter.notifyDataSetChanged()
    }

    //뒤로가기 2번 종료
    override fun onBackPressed() {
        val toast = Toast.makeText(this, "\'뒤로\'버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)

        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast.show()
        } else {
            toast.cancel()
            this.finish()
        }
    }
}
