package com.example.sopt.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sopt.R
import com.example.sopt.feature.fragment.ListFragment
import com.example.sopt.feature.fragment.UserFragment

class GitActivity : AppCompatActivity() {
    lateinit var gitId : String
    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git)

        gitFunction()
    }

    private fun gitFunction() {
        gitId = intent.getStringExtra("id")

        // 1. Top & Below Fragment
        supportFragmentManager.beginTransaction()
            .add(R.id.frameGitTop, UserFragment().apply {
                arguments = Bundle().apply {
                    putString("id", gitId)
                }
            })
            .add(R.id.frameGitBelow, ListFragment().apply {
                arguments = Bundle().apply {
                    putString("id", gitId)
                }
            })
            .commit()

        // 2. RecyclerView

        // 3. handle click event

    }

    private fun replaceAboveFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameGitTop, fragment).commit()
    }

    private fun replaceBelowFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameGitBelow, fragment).commit()
    }

    //뒤로가기 2번 종료
    override fun onBackPressed() {
        val toast = Toast.makeText(this, "\'뒤로\'버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)

        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast.show()
        } else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            this.finish()
            toast.cancel()
        }
    }
}